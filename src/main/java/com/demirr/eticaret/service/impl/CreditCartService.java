package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.service.PaymentFactoryService;
import org.springframework.stereotype.Service;

@Service
public class CreditCartService implements PaymentFactoryService {
    public boolean validate() {
        boolean isValidCardNumber ;
        boolean isValidExpirationDate ;
        boolean isValidCvv ;
        boolean isCreditCardValid;

        boolean isCreditLimitExceeded=isCreditLimitExceeded();
        System.out.println("Kredi kartı ile ödeme gerçekleşti");
        return true;
    }

    private boolean isCreditLimitExceeded() {
        return true;
    }
}
