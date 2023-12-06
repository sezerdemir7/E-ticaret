package com.demirr.eticaret.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemRequest {

    private int adet;
    private Long productId;
    private Long customerId;



}
