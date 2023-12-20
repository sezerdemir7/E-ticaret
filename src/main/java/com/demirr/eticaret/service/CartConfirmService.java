package com.demirr.eticaret.service;

import com.demirr.eticaret.dto.response.OrderResponse;

public interface CartConfirmService {

    OrderResponse createOrderByCartId(Long cartId);

}