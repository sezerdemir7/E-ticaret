package com.demirr.eticaret.exception.customerexception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String msg) {
        super(msg);
    }
}
