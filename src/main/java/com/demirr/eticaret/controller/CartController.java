package com.demirr.eticaret.controller;

import com.demirr.eticaret.dto.response.CartResponse;
import com.demirr.eticaret.entities.Cart;
import com.demirr.eticaret.entities.CartItem;
import com.demirr.eticaret.service.CartService;
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
    public List<Cart> getAllCart(){
        return cartService.getAllCart();
    }

    @GetMapping("/{customerId}")
    public List<CartResponse> getCustomerCartByCustomerId(@RequestParam Long customerId){
        return cartService.getCustomerCartByCustomerId(customerId);
    }








}
