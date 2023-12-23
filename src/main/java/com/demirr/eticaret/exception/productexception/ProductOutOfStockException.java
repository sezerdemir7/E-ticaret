package com.demirr.eticaret.exception.productexception;

public class ProductOutOfStockException extends RuntimeException{
    public ProductOutOfStockException(String msg) {
        super(msg);
    }
}
