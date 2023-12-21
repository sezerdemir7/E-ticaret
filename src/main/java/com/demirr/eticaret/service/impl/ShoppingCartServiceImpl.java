package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.entities.Cart;
import com.demirr.eticaret.entities.CartItem;
import com.demirr.eticaret.entities.Customer;
import com.demirr.eticaret.service.CartService;
import com.demirr.eticaret.service.CustomerService;
import com.demirr.eticaret.service.ShoppingCartService;
import org.springframework.stereotype.Service;



@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final CustomerService customerService;
    private final CartService cartService;

    public ShoppingCartServiceImpl(CustomerService customerService, CartService cartService) {
        this.customerService = customerService;
        this.cartService = cartService;


    }

    public Cart addProductToCart(CartItem cartItem) {

        Customer customer = customerService.getCustomer(cartItem.getCustomerId());
        Cart cart = cartService.getCartByCostumerId(cartItem.getCustomerId());
        double totalPrice=0;

        cart.getCartItems().add(cartItem);
        for (CartItem itemSet:cart.getCartItems()) {
            totalPrice +=itemSet.getToplamFiyat();
        }
        cart.setTotalPrice(totalPrice);
        Cart tosave=cartService.saveCart(cart);
        //customer.setCart(cart);
        //customerService.save(customer);

        return tosave;

    }
}
