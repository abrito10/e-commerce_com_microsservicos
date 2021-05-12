package com.abrito10.ecommerce.checkout.service;

import com.abrito10.ecommerce.checkout.entity.CheckoutEntity;
import com.abrito10.ecommerce.checkout.resource.checkout.CheckoutRequest;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);

    Optional<CheckoutEntity> updateStatus(String checkoutCode, CheckoutEntity.Status status);
}
