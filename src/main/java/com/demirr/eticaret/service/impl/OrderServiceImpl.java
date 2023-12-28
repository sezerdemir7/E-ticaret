package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.dto.response.OrderResponse;
import com.demirr.eticaret.entities.Order;
import com.demirr.eticaret.entities.Store;
import com.demirr.eticaret.repository.OrderRepository;
import com.demirr.eticaret.service.OrderService;
import com.demirr.eticaret.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final StoreService storeService;


    public OrderServiceImpl(OrderRepository orderRepository, StoreService storeService){
        this.orderRepository = orderRepository;
        this.storeService = storeService;

    }


    public List<OrderResponse> getActiveOrdersByCustomerId(Long customerId) {
        List<Order> orders = orderRepository.findByCustomerIdAndStatus(customerId, false);

        return orders.stream().map((order)-> new OrderResponse(order.getTeslimatAdresi(), order.getToplamTutar(),
                    "Devam ediyor",order.getOrderDate())).collect(Collectors.toList());

    }

    public List<Order> getCompletedOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerIdAndStatus(customerId, true);
    }

    public OrderResponse saveOrder(Order request){

        Order order= orderRepository.save(request);

        Store store=order.getStore();
        store.getOrders().add(order);
        storeService.updateStoreOrders(store);
        return new OrderResponse(order.getTeslimatAdresi(),order.getToplamTutar(),"teslim edilmedi",order.getOrderDate());
    }


}
