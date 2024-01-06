package com.demirr.eticaret.dto.request;

import com.demirr.eticaret.constants.PaymentType;
import lombok.Data;

@Data
public class CreateOrderRequest {
    private Long customerId;
    private PaymentType paymentType;
}
