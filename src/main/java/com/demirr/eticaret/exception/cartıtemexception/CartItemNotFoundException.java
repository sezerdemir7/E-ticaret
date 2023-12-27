package com.demirr.eticaret.exception.cartıtemexception;

public class CartItemNotFoundException extends RuntimeException{
    public CartItemNotFoundException(String msg) {
        super(msg);
    }
}
