package me.lubin.springcloud.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentService{
    @Override
    public String paymentOk(Integer id) {
        return "PaymentService.paymentOk fallback";
    }

    @Override
    public String paymentTimeout(Integer id) {
        return "PaymentService.paymentTimeout fallback";
    }
}
