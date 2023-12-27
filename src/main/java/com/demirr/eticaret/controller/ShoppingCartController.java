package com.demirr.eticaret.controller;

import com.demirr.eticaret.dto.response.OrderResponse;
import com.demirr.eticaret.service.ShoppingCartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/shoppingcart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/confirim/{customerId}")
    public ResponseEntity<OrderResponse> saveCartByCustomerId(@RequestParam Long customerId){
        return new ResponseEntity<>(shoppingCartService.createOrderByCustomerId(customerId), HttpStatus.OK);

    }
    @DeleteMapping("/cartitem/{customerId}/{productId}")
    public ResponseEntity<Void> deleteCartItemByProductId(@RequestParam Long customerId,@RequestParam Long productId){
        shoppingCartService.deleteCartItemByCustomerIdAndProductId(customerId,productId);
        return new ResponseEntity<>(OK);
    }
}
