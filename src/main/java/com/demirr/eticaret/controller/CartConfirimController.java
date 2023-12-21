package com.demirr.eticaret.controller;

import com.demirr.eticaret.dto.response.OrderResponse;
import com.demirr.eticaret.entities.Order;
import com.demirr.eticaret.service.CartConfirmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sepetOnayla")
public class CartConfirimController {

    private final CartConfirmService cartConfirmService;

    public CartConfirimController(CartConfirmService cartConfirmService) {
        this.cartConfirmService = cartConfirmService;
    }

    @PostMapping()
    public ResponseEntity<OrderResponse> saveCartByCartId(@RequestParam Long cartId){
        return new ResponseEntity<OrderResponse>(cartConfirmService.createOrderByCustomerId(cartId), HttpStatus.OK);

    }
}
