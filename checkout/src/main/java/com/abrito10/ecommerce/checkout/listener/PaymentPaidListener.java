package com.abrito10.ecommerce.checkout.listener;

import com.abrito10.ecommerce.checkout.entity.CheckoutEntity;
import com.abrito10.ecommerce.checkout.service.CheckoutService;
import com.abrito10.ecommerce.checkout.streaming.PaymentPaidSink;
import com.abrito10.ecommerce.payment.event.PaymentCreatedEvent;

import lombok.RequiredArgsConstructor;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutService checkoutService;

    @StreamListener(PaymentPaidSink.INPUT)
    //PaymentCreatedEvent
    public void handler(PaymentCreatedEvent paymentCreatedEvent) {
        checkoutService.updateStatus(paymentCreatedEvent.getCheckoutCode().toString(), CheckoutEntity.Status.APPROVED);
    }
}
