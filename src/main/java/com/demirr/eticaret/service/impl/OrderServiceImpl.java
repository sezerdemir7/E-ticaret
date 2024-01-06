package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.dto.response.OrderResponse;
import com.demirr.eticaret.entities.CartItem;
import com.demirr.eticaret.entities.Order;
import com.demirr.eticaret.entities.OrderDetail;
import com.demirr.eticaret.entities.Store;
import com.demirr.eticaret.repository.OrderRepository;
import com.demirr.eticaret.service.OrderDetailService;
import com.demirr.eticaret.service.OrderService;
import com.demirr.eticaret.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final StoreService storeService;
    private final OrderDetailService orderDetailService;


    public OrderServiceImpl(OrderRepository orderRepository, StoreService storeService, OrderDetailService orderDetailService){
        this.orderRepository = orderRepository;
        this.storeService = storeService;
        this.orderDetailService = orderDetailService;
    }


    public List<OrderResponse> getActiveOrdersByCustomerId(Long customerId) {
        List<Order> orders = orderRepository.findByCustomerIdAndStatus(customerId, false);

        return orders.stream().map((order)-> new OrderResponse(order.getTeslimatAdresi(), order.getToplamTutar(),
                    "Devam ediyor",order.getOrderDate())).collect(Collectors.toList());

    }

    public List<Order> getCompletedOrdersByCustomerId(Long customerId) {
        return orderRepository.findByCustomerIdAndStatus(customerId, true);
    }

    public Order saveOrder(Order request,Set<CartItem> cartItems){

        List<OrderDetail> orderDetails = orderDetailService.createOrderDetails(cartItems, request);
        request.setOrderDetails(orderDetails);
        Order order= orderRepository.save(request);

        Store store=order.getStore();
        store.getOrders().add(order);
        storeService.updateStoreOrders(store);
        return order;
        //return new OrderResponse(order.getTeslimatAdresi(),order.getToplamTutar(),"teslim edilmedi",order.getOrderDate());
    }


}
