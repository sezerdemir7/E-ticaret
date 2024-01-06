package com.demirr.eticaret.service;

import com.demirr.eticaret.dto.response.OrderDetailResponse;
import com.demirr.eticaret.entities.CartItem;
import com.demirr.eticaret.entities.Order;
import com.demirr.eticaret.entities.OrderDetail;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface OrderDetailService {

    OrderDetail saveOrderDetail(OrderDetail orderDetail);
    List<OrderDetail> createOrderDetails(Set<CartItem> cartItems, Order order);

    List<OrderDetailResponse> getOrderDetailByOrderId(Long orderId);

}
