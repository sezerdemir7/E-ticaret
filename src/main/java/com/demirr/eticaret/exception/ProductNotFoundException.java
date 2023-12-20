package com.demirr.eticaret.exception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String msg){
        super(msg);
    }
}
