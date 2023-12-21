package com.demirr.eticaret.service;

import com.demirr.eticaret.dto.response.OrderResponse;
import com.demirr.eticaret.entities.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<OrderResponse> getActiveOrdersByCustomerId(Long customerId);

    List<Order> getCompletedOrdersByCustomerId(Long customerId);

    OrderResponse saveOrder(Order request);

}
