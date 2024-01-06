package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.service.PaymentFactoryService;
import org.springframework.stereotype.Service;

@Service
public class PaypalAdapterService implements PaymentFactoryService{

    private final PayPalPaymentService payPalPaymentService;

    public PaypalAdapterService(PayPalPaymentService payPalPaymentService) {
        this.payPalPaymentService = payPalPaymentService;
    }

    @Override
    public boolean validate() {
        return payPalPaymentService.PaymentProces();
    }
}
