package com.abrito10.ecommerce.payment.service;

import java.util.Optional;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.abrito10.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.abrito10.ecommerce.payment.entity.PaymentEntity;
import com.abrito10.ecommerce.payment.repository.PaymentRepository;


@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent) {
        final PaymentEntity paymentEntity = PaymentEntity.builder()
                .checkoutCode(checkoutCreatedEvent.getCheckoutCode())
                .code(UUID.randomUUID().toString())
                .build();
        paymentRepository.save(paymentEntity);
        return Optional.of(paymentEntity);
    }
}
