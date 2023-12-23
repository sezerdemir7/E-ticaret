package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.dto.response.OrderResponse;
import com.demirr.eticaret.entities.*;
import com.demirr.eticaret.service.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Set;
@Service
public class CartConfirimServiceImpl implements CartConfirmService{
    private final CartService cartService;
    private final CustomerService customerService;
    private final KargoService kargoService;
    private final PaymentService paymentService;
    private final OrderService orderService;
    private final CartItemService cartItemService;
    private final ProductService productService;

    public CartConfirimServiceImpl(CartService cartService, CustomerService customerService, KargoService kargoService,
                                   PaymentService paymentService, OrderService orderService, CartItemService cartItemService, ProductService productService) {
        this.cartService = cartService;
        this.customerService = customerService;
        this.kargoService = kargoService;
        this.paymentService = paymentService;
        this.orderService = orderService;
        this.cartItemService = cartItemService;
        this.productService = productService;
    }

    public OrderResponse createOrderByCustomerId(Long customerId){
        Order toSave= new Order();
        Cart cart=cartService.getCartByCustomerId(customerId);
        Set<CartItem> cartItems =cart.getCartItems();
        Payment payment;
        String teslimatAdresi;
        Kargo kargo;
        LocalDateTime tahminiTaslimat;


        int totalOrderPrice= cartItemService.getTotalCartPrice(cartItems.stream().toList());
        teslimatAdresi=customerService.getOneCustomerById(cart.getCustomer().getId()).getAdres();
        kargo=kargoService.createKargo(cart.getCustomer().getId(),teslimatAdresi);
        tahminiTaslimat = kargo.getTahminiTaslimat().atStartOfDay();

        payment=paymentService.createPayment(cart.getCustomer().getId(),totalOrderPrice);


        toSave.setCustomer(cart.getCustomer());
        toSave.setStore(cart.getStore());
        toSave.setTeslimatAdresi(teslimatAdresi);
        toSave.setKargo(kargo);
        toSave.setPayment(payment);
        toSave.setToplamTutar(totalOrderPrice);
        toSave.setStatus(false);



        for (CartItem items:cartItems) {
            productService.updateProductStock(items.getProduct().getId(),items.getProduct().getStok());
        }

        return orderService.saveOrder(toSave);


    }
}
