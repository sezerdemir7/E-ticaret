package com.demirr.eticaret.exception.cartexception;

public class CartNotFoundException extends RuntimeException{
    public CartNotFoundException(String msg) {
        super(msg);
    }
}
