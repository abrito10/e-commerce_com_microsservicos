package com.abrito10.ecommerce.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abrito10.ecommerce.payment.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
}
