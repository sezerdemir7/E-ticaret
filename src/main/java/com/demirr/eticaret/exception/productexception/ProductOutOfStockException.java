package com.demirr.eticaret.exception.productexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProductOutOfStockException extends RuntimeException{
    public ProductOutOfStockException(String msg) {
        super(msg);
    }
}
