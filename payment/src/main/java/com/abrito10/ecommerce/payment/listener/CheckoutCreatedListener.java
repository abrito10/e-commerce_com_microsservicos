package com.abrito10.ecommerce.payment.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.abrito10.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.abrito10.ecommerce.payment.entity.PaymentEntity;
import com.abrito10.ecommerce.payment.event.PaymentCreatedEvent;
import com.abrito10.ecommerce.payment.service.PaymentService;
import com.abrito10.ecommerce.payment.streaming.CheckoutProcessor;

@Component
@RequiredArgsConstructor
@Slf4j
public class CheckoutCreatedListener {

    private final CheckoutProcessor checkoutProcessor;

    private final PaymentService paymentService;

    @StreamListener(CheckoutProcessor.INPUT)
    public void handler(CheckoutCreatedEvent checkoutCreatedEvent) {
        //log.info("checkoutCreatedEvent={}", checkoutCreatedEvent);
        final PaymentEntity paymentEntity = paymentService.create(checkoutCreatedEvent).orElseThrow();
        final PaymentCreatedEvent paymentCreatedEvent = PaymentCreatedEvent.newBuilder()
                .setCheckoutCode(paymentEntity.getCheckoutCode())
                .setPaymentCode(paymentEntity.getCode())
                .build();
        checkoutProcessor.output().send(MessageBuilder.withPayload(paymentCreatedEvent).build());
    }
}
