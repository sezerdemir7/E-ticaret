package com.demirr.eticaret.service.impl;

import org.springframework.stereotype.Service;

@Service
public class PayPalPaymentService {

    public Boolean PaymentProces(){
        System.out.println("Paypal ile ödemeniz gerçekleşti");
        return true;
    }
}
