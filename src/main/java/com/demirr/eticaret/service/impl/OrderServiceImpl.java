package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.dto.response.OrderResponse;
import com.demirr.eticaret.entities.Order;
import com.demirr.eticaret.repository.OrderRepository;
import com.demirr.eticaret.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    public OrderResponse getActiveOrdersByCustomerId(Long customerId) {
        Optional<Order> orders = orderRepository.findByCustomerIdAndStatus(customerId, false);
        if (orders.isPresent()) {
            Order order = orders.get();
            return new OrderResponse(order.getTeslimatAdresi(), order.getToplamTutar(), "devam ediyor");
        } else {

            return null;
        }
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


}
