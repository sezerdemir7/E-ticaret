package com.demirr.eticaret.exception.storeexception;

public class StoreNotFoundException extends RuntimeException{
    public StoreNotFoundException(String msg) {
        super(msg);
    }
}
