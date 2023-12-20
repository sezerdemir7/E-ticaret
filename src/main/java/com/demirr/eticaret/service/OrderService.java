package com.demirr.eticaret.service;

import com.demirr.eticaret.dto.response.OrderResponse;
import com.demirr.eticaret.entities.Order;

import java.util.Optional;

public interface OrderService {

    OrderResponse getActiveOrdersByCustomerId(Long customerId);

    Optional<Order> getCompletedOrdersByCustomerId(Long customerId);

    OrderResponse saveOrder(Order request);

}
