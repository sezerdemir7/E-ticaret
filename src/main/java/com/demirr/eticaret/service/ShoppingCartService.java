package com.demirr.eticaret.service;

import com.demirr.eticaret.dto.request.CreateOrderRequest;
import com.demirr.eticaret.dto.response.OrderResponse;

public interface ShoppingCartService {



    OrderResponse createOrderByRequest(CreateOrderRequest request);

    void deleteCartItemByCustomerIdAndProductId(Long customerId, Long productId);
    //OrderResponse createOrderByCustomerId(Long customerId);
}