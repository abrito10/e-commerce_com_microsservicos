package com.abrito10.ecommerce.payment.service;

import com.abrito10.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.abrito10.ecommerce.payment.entity.PaymentEntity;

import java.util.Optional;

public interface PaymentService {

    Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent);
}
