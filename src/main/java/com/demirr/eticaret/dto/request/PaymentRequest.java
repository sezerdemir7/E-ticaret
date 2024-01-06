package com.demirr.eticaret.dto.request;

import com.demirr.eticaret.constants.PaymentType;
import com.demirr.eticaret.entities.Customer;
import lombok.Data;

@Data
public class PaymentRequest {
    private Long customerId;
    //private PaymentType paymentType;
    private int odenecekTutar;
    private PaymentType paymentType;
}
