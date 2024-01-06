package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.dto.response.OrderDetailResponse;
import com.demirr.eticaret.dto.response.OrderResponse;
import com.demirr.eticaret.entities.CartItem;
import com.demirr.eticaret.entities.Order;
import com.demirr.eticaret.entities.OrderDetail;
import com.demirr.eticaret.repository.OrderDetailRepository;
import com.demirr.eticaret.service.OrderDetailService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OrderDetailServcieImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    public OrderDetailServcieImpl(OrderDetailRepository orderDetailRepository) {
        this.orderDetailRepository = orderDetailRepository;
    }

    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
       return orderDetailRepository.save(orderDetail);
    }
    public List<OrderDetail> createOrderDetails(Set<CartItem> cartItems, Order order) {
        List<OrderDetail> orderDetails = new ArrayList<>();

        for (CartItem cartItem : cartItems) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setAdet(cartItem.getAdet());
            orderDetail.setSiparisFiyati(cartItem.getProduct().getFiyat());
            orderDetail.setProduct(cartItem.getProduct());
            orderDetail.setOrder(order);
            orderDetails.add(orderDetail);
        }


        return orderDetails;
    }


    public List<OrderDetailResponse> getOrderDetailByOrderId(Long orderId) {
        List<OrderDetail> orderDetail=orderDetailRepository.findOrderDetailByOrderId(orderId);

        return orderDetail.stream()
                .map(orderDetail1 -> new OrderDetailResponse(orderDetail1))
                .collect(Collectors.toList());

    }
}
