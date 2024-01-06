package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.dto.request.CreateOrderRequest;
import com.demirr.eticaret.dto.response.OrderResponse;
import com.demirr.eticaret.entities.*;
import com.demirr.eticaret.service.*;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final CartService cartService;
    private final KargoService kargoService;
    private final PaymentService paymentService;
    private final OrderService orderService;
    private final CartItemService cartItemService;
    private final ProductService productService;

    public ShoppingCartServiceImpl(CartService cartService, KargoService kargoService,PaymentService paymentService,
                                   OrderService orderService, CartItemService cartItemService, ProductService productService) {
        this.cartService = cartService;
        this.kargoService = kargoService;
        this.paymentService = paymentService;
        this.orderService = orderService;
        this.cartItemService = cartItemService;
        this.productService = productService;
    }

    public OrderResponse createOrderByRequest(CreateOrderRequest request) {
        Order toSave= new Order();
        Cart cart=cartService.getCartByCustomerId(request.getCustomerId());
        Set<CartItem> cartItems =cart.getCartItems();
        Payment payment;
        Order order;


        int totalOrderPrice= cartItemService.getTotalCartPrice(cartItems.stream().toList());


        payment=paymentService.createPayment(cart.getCustomer().getId(),totalOrderPrice,request.getPaymentType());



        toSave.setCustomer(cart.getCustomer());
        toSave.setStore(cart.getStore());
        toSave.setTeslimatAdresi(cart.getCustomer().getAdres());
        toSave.setPayment(payment);
        toSave.setToplamTutar(totalOrderPrice);
        toSave.setStatus(false);

        order=orderService.saveOrder(toSave,cartItems);
        kargoService.createKargo(cart.getCustomer().getId(),order);

        for (CartItem items:cartItems) {
            productService.updateProductStock(items.getProduct().getId(),items.getAdet());

        }

        cartItemService.updateCartItem(cartItems);
        cartService.updateCart(cart);

        return new OrderResponse(order.getTeslimatAdresi(),order.getToplamTutar(),"teslim edilmedi",order.getOrderDate());
    }


    public void deleteCartItemByCustomerIdAndProductId(Long customerId, Long productId) {
        cartItemService.deleteCartItemByCustomerIdAndProductId(customerId,productId);
    }

    /*
    public OrderResponse createOrderByCustomerId(Long customerId){
        Order toSave= new Order();
        Cart cart=cartService.getCartByCustomerId(customerId);
        Set<CartItem> cartItems =cart.getCartItems();
        Payment payment;
        Kargo kargo;


        int totalOrderPrice= cartItemService.getTotalCartPrice(cartItems.stream().toList());
        kargo=kargoService.createKargo(cart.getCustomer().getId());

       // payment=paymentService.createPayment(cart.getCustomer().getId(),totalOrderPrice);


        toSave.setCustomer(cart.getCustomer());
        toSave.setStore(cart.getStore());
        toSave.setTeslimatAdresi(cart.getCustomer().getAdres());
        toSave.setKargo(kargo);
        //toSave.setPayment(payment);
        toSave.setToplamTutar(totalOrderPrice);
        toSave.setStatus(false);

        OrderResponse orderResponse=orderService.saveOrder(toSave,cartItems);

        for (CartItem items:cartItems) {
            productService.updateProductStock(items.getProduct().getId(),items.getAdet());

        }

        cartItemService.updateCartItem(cartItems);
        cartService.updateCart(cart);

        return orderResponse;

    }
     */
}
