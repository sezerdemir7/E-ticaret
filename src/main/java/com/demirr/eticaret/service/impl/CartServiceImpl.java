package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.entities.Cart;
import com.demirr.eticaret.entities.CartItem;
import com.demirr.eticaret.repository.CartRepository;

public class CartServiceImpl {

    private final CartRepository cartRepository;

    public CartServiceImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    public Cart addCartItemToCart(CartItem cartItem,Long customerId){
return null;
    }
}
