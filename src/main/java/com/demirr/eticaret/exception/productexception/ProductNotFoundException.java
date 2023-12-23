package com.demirr.eticaret.exception.productexception;

public class ProductNotFoundException extends RuntimeException{

    public ProductNotFoundException(String msg){
        super(msg);
    }
}
