package com.demirr.eticaret.service;

import com.demirr.eticaret.dto.response.CartResponse;
import com.demirr.eticaret.entities.Cart;
import com.demirr.eticaret.entities.CartItem;
import com.demirr.eticaret.entities.Customer;
import com.demirr.eticaret.entities.Store;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CartService {


    Cart getOneCartById(Long cartId);

    List<Cart> getAllCart();

    List<CartResponse> getCustomerCartByCustomerId(Long customerId);

    Cart getCartByCostumerId(Long customerId);

    Cart saveCart(Cart cart);

    Cart addCartItemToCart( CartItem cartItem);

    Cart getCartByCustomerId(Long customerId);

    Cart createCartByCustomerId(Customer customer, Store store);

    void updateCart(Cart cart);

    void deleteCartByCartId(Long id);
}






