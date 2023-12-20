package com.demirr.eticaret.controller;

import com.demirr.eticaret.dto.request.CartItemRequest;
import com.demirr.eticaret.dto.response.CartItemResponse;
import com.demirr.eticaret.entities.CartItem;
import com.demirr.eticaret.service.CartItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping("/{cartItemId}")
    public ResponseEntity<List<CartItemResponse>> getCartItemById(@RequestParam Long cartItemId){
        return new ResponseEntity(cartItemService.getCartItemById(cartItemId),OK);
    }
    @GetMapping("/customerId/{customerId}")
    public ResponseEntity<List<CartItemResponse>> getCartItemByCustomerId(@RequestParam Long customerId){
        return new ResponseEntity(cartItemService.getCartItemByCustomerId(customerId),OK);
    }

    //sepete ekleme
    @PostMapping()
    public ResponseEntity<CartItemResponse> saveCartItem(@RequestBody CartItemRequest request){
        return new ResponseEntity<>(cartItemService.saveCartItem(request), HttpStatus.CREATED);
    }


    @DeleteMapping("/{customerId}/{productId}")
    public ResponseEntity<Void> deleteCartItemByProductId(@RequestParam Long customerId,Long productId){
        cartItemService.deleteCartItemByCustomerIdAndProductId(customerId,productId);
        return new ResponseEntity<>(OK);
    }


}
