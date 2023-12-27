package com.demirr.eticaret.service;

import com.demirr.eticaret.dto.response.OrderResponse;

public interface ShoppingCartService {

    OrderResponse createOrderByCustomerId(Long customerId);

    void deleteCartItemByCustomerIdAndProductId(Long customerId, Long productId);
}