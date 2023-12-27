package com.demirr.eticaret.controller;

import com.demirr.eticaret.dto.response.CartResponse;
import com.demirr.eticaret.entities.Cart;
import com.demirr.eticaret.entities.CartItem;
import com.demirr.eticaret.service.CartService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    /*@GetMapping("{id}")
    public ResponseEntity<Optional<CartItem>> getCartById(@RequestParam Long id){
        return new ResponseEntity<>(cartService.getCartById(id), HttpStatus.OK);
    }

     */

    @GetMapping
    public ResponseEntity<List<Cart>> getAllCart(){
        return new ResponseEntity<>(cartService.getAllCart(),HttpStatus.OK);
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<List<CartResponse>> getCustomerCartByCustomerId(@Valid @RequestParam Long customerId){
        return new ResponseEntity<>(cartService.getCustomerCartByCustomerId(customerId),HttpStatus.OK);
    }








}
