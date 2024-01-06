package com.demirr.eticaret.dto.response;

import com.demirr.eticaret.constants.PaymentType;
import com.demirr.eticaret.entities.Payment;
import lombok.Data;

@Data
public class PaymentResponse {

    private Long customerId;
    private int odenenTutar;
    private PaymentType paymentType;

    public PaymentResponse(Payment payment) {
        this.customerId = payment.getCustomer().getId();
        this.odenenTutar = payment.getOdenenTutar();
        this.paymentType = payment.getPaymentType();
    }
}
