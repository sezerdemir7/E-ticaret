package com.demirr.eticaret.exception;

import com.demirr.eticaret.exception.cartıtemexception.CartItemNotFoundException;
import com.demirr.eticaret.exception.categoryexception.CategoryNotFoundException;
import com.demirr.eticaret.exception.customerexception.CustomerNotFoundException;
import com.demirr.eticaret.exception.productexception.ProductNotFoundException;
import com.demirr.eticaret.exception.productexception.ProductOutOfStockException;
import com.demirr.eticaret.exception.sellerexception.SellerNotFoundException;
import com.demirr.eticaret.exception.storeexception.StoreNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GeneralExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatusCode status,
                                                                  WebRequest request) {

        Map<String,String> erors=new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error->{
            String fieldName=((FieldError) error).getField();
            String errorMessage= error.getDefaultMessage();;
            erors.put(fieldName,errorMessage);
        });

        return new ResponseEntity<>(erors,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductOutOfStockException.class)
    public ResponseEntity<?> productOutOfStockException(ProductOutOfStockException exception){
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), NOT_FOUND);

    }
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), NOT_FOUND);

    }
    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<String> handleCategoryNotFounException(CategoryNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(),NOT_FOUND);
    }
    @ExceptionHandler(StoreNotFoundException.class)
    public ResponseEntity<String> handleStoreNotFoundException(StoreNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), NOT_FOUND);
    }
    @ExceptionHandler(CartItemNotFoundException.class)
    public ResponseEntity<String> handleCartItemNotFoundException(CartItemNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), NOT_FOUND);
    }
    @ExceptionHandler(StoreNotFoundException.class)
    public ResponseEntity<String> handleSellerNotFoundException(SellerNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), NOT_FOUND);
    }
}
