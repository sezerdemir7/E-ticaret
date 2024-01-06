package com.demirr.eticaret.exception.paymentexception;

public class PaymentTypeNotFoundException extends RuntimeException{

    public PaymentTypeNotFoundException(String msg) {
        super(msg);
    }
}
