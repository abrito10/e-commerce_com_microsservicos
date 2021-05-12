package com.abrito10.ecommerce.checkout.config;

import com.abrito10.ecommerce.checkout.streaming.CheckoutCreatedSource;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;
//import com.abrito10.ecommerce.checkout.streaming.PaymentPaidSink;

@Configuration
@EnableBinding(value = {
        CheckoutCreatedSource.class,
        //PaymentPaidSink.class
})
public class StreamingConfig {
}
