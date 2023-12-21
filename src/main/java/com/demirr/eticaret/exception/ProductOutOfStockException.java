package com.demirr.eticaret.exception;

public class ProductOutOfStockException extends RuntimeException{
    public ProductOutOfStockException(String msg) {
        super(msg);
    }
}
