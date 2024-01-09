package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.service.PaymentFactoryService;
import org.springframework.stereotype.Service;

@Service
public class DebitCartService implements PaymentFactoryService {

    public boolean validate() {

        boolean isValidCardNumber ;
        boolean isValidExpirationDate ;
        boolean isValidCvv;
        System.out.println("Banka kartı ile ödeme gerçekleşti");
        return true;
    }
}
