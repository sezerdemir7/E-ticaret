package com.demirr.eticaret.controller;

import com.demirr.eticaret.dto.request.CartItemRequest;
import com.demirr.eticaret.dto.response.CartItemResponse;
import com.demirr.eticaret.entities.CartItem;
import com.demirr.eticaret.service.CartItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {

    private final CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<CartItemResponse>> getCartItemById(@PathVariable Long id){
        return ResponseEntity.ok(cartItemService.getCartItemById(id));
    }

    //sepete ekleme
    @PostMapping()
    public ResponseEntity<CartItemResponse> saveCartItem(@RequestBody CartItemRequest request){
        return new ResponseEntity<>(cartItemService.saveCartItem(request), HttpStatus.CREATED);
    }


    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteCartItemByProductId(Long productId){
        cartItemService.deleteCartItemByProductId(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
