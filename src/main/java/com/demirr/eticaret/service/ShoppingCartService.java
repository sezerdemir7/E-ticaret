package com.demirr.eticaret.service;

import com.demirr.eticaret.entities.Cart;
import com.demirr.eticaret.entities.CartItem;
import com.demirr.eticaret.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartService {

    private final CustomerService customerService;
    private final CartService cartService;


    public ShoppingCartService(CustomerService customerService, CartService cartService) {
        this.customerService = customerService;
        this.cartService = cartService;

    }

    public void addProductToCart(CartItem cartItem) {

        Customer customer = customerService.getCustomer(cartItem.getCustomerId());
        Cart cart = cartService.getCartByCostumerId(cartItem.getCustomerId());
        System.out.println("cart bilgileri: "+cart.getStoreId());
        cart.getCartItems().add(cartItem);
        cartService.saveCart(cart);

        customer.setCart(cart);
        customerService.save(customer);

    }
}
