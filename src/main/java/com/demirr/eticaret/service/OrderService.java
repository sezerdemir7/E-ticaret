package com.demirr.eticaret.service;

import com.demirr.eticaret.dto.response.OrderResponse;
import com.demirr.eticaret.entities.Order;
import com.demirr.eticaret.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {


    private final OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository){
        this.orderRepository = orderRepository;

    }

    //bu kısım hatalıdır ekra bakılacak geri dönüş tipinde sıkıntı var
    public OrderResponse getActiveOrdersByCustomerId(Long customerId){
        Optional<Order> orders= orderRepository.findByCustomerIdAndStatus(customerId,true);
        System.out.println("sistemdeki orderler===="+orders);
        System.out.println(customerId);

            return (OrderResponse) orders.stream().map(order -> new OrderResponse(order.getTeslimatAdresi(),order.getToplamTutar(),
                    "devam ediyor"));
    }
    public Optional<Order> getCompletedOrdersByCustomerId(Long customerId){
        return orderRepository.findByCustomerIdAndStatus(customerId,false);
    }

    public OrderResponse saveOrder(Order request){
        Order order= orderRepository.save(request);
        String durum;
        if(order.isStatus()){
            durum="Teslim edildi";
        }
        else {
            durum="Teslim edilmedi";
        }

        return new OrderResponse(order.getTeslimatAdresi(),order.getToplamTutar(),durum);
    }

    /*
    public Order createOrderByCartId(Long cartId){

        Order toSave= new Order();
        Cart cart=cartService.getOneCartById(cartId);
        Set<CartItem> cartItems =cart.getCartItems();

        Kargo kargo=kargoService.getKargoByCustomerId(cart.getCostumerId());

        String teslimatAdresi=customerService.getOneCustomerById(cart.getCostumerId()).getAdres();

        LocalDateTime tahminiTaslimat = kargo.getTahminiTaslimat().atStartOfDay();

        LocalDateTime bugun = LocalDateTime.now();


        toSave.setCustomerId(cart.getCostumerId());
        toSave.setOrderDate(LocalDateTime.now());
        toSave.setStoreId(cart.getStoreId());
        toSave.setTeslimatAdresi(teslimatAdresi);
        toSave.setKargo(kargo.getId());
        toSave.setPaymentId(paymentService.getPaymentByCustomerId(cart.getCostumerId()).getId());
        toSave.setToplamTutar(paymentService.getPaymentByCustomerId(cart.getCostumerId()).getOdenenTutar());
        if(tahminiTaslimat.isBefore(bugun)){
            toSave.setStatus(true);
        }
        else {
            toSave.setStatus(false);
        }

        return orderRepository.save(toSave);
        */



}



