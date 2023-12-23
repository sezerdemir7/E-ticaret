package com.demirr.eticaret.exception.categoryexception;

public class CategoryNotFoundException extends RuntimeException{
    public CategoryNotFoundException(String msg) {
        super(msg);
    }
}
