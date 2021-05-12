package com.abrito10.ecommerce.payment.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

import com.abrito10.ecommerce.payment.streaming.CheckoutProcessor;

@Configuration
@EnableBinding(CheckoutProcessor.class)
public class StreamingConfig {
}
