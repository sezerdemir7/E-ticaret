package com.demirr.eticaret.service;

import com.demirr.eticaret.entities.Cart;
import com.demirr.eticaret.entities.CartItem;

public interface ShoppingCartService {

    Cart addProductToCart(CartItem cartItem);

}
