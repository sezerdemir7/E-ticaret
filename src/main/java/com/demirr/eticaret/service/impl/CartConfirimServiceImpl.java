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

    public CartConfirimServiceImpl(CartService cartService, CustomerService customerService, KargoService kargoService,
                                   PaymentService paymentService, OrderService orderService, CartItemService cartItemService) {
        this.cartService = cartService;
        this.customerService = customerService;
        this.kargoService = kargoService;
        this.paymentService = paymentService;
        this.orderService = orderService;
        this.cartItemService = cartItemService;
    }

    public OrderResponse createOrderByCartId(Long cartId){
        Order toSave= new Order();
        Cart cart=cartService.getOneCartById(cartId);
        Set<CartItem> cartItems =cart.getCartItems();
        Payment payment;

        int totalOrderPrice= cartItemService.getTotalCartPrice(cartItems.stream().toList());

        String teslimatAdresi=customerService.getOneCustomerById(cart.getCustomer().getId()).getAdres();

        Kargo kargo=kargoService.createKargo(cart.getCustomer().getId(),teslimatAdresi);
        LocalDateTime tahminiTaslimat = kargo.getTahminiTaslimat().atStartOfDay();

        LocalDateTime bugun = LocalDateTime.now();

        payment=paymentService.createPayment(cart.getCustomer().getId(),totalOrderPrice);


        toSave.setCustomer(cart.getCustomer());
        //toSave.setOrderDate(LocalDateTime.now());
        toSave.setStoreId(cart.getStoreId());
        toSave.setTeslimatAdresi(teslimatAdresi);
        toSave.setKargoId(kargo.getId());
        toSave.setPaymentId(payment.getId());
        toSave.setToplamTutar(totalOrderPrice);

        if(tahminiTaslimat.isBefore(bugun)){
            toSave.setStatus(true);
        }
        else {
            toSave.setStatus(false);
        }

        return orderService.saveOrder(toSave);


    }
}
