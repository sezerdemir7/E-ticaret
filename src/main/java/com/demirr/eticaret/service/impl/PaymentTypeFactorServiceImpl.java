package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.constants.PaymentType;
import com.demirr.eticaret.exception.paymentexception.PaymentTypeNotFoundException;
import com.demirr.eticaret.service.PaymentFactoryService;
import org.springframework.stereotype.Service;

@Service
public class PaymentTypeFactorServiceImpl {
    public static PaymentFactoryService getInstance(PaymentType type){

        switch (type){
            case CREDIT_CARD :return new CreditCartService();
            case DEBIT_CARD:return new DebitCartService();
            case PAY_PAL:return new PaypalAdapterService(new PayPalPaymentService());
            default:throw new PaymentTypeNotFoundException("Hatali ödeme tipili seçildi");
        }


    }
}
