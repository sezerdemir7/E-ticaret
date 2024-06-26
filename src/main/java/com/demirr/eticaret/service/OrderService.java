package com.demirr.eticaret.service;

import com.demirr.eticaret.dto.response.OrderResponse;
import com.demirr.eticaret.entities.CartItem;
import com.demirr.eticaret.entities.Order;

import java.util.List;
import java.util.Set;

public interface OrderService {

    List<OrderResponse> getActiveOrdersByCustomerId(Long customerId);

    List<Order> getCompletedOrdersByCustomerId(Long customerId);

    Order saveOrder(Order request,Set<CartItem> cartItems);

}
