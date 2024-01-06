package com.demirr.eticaret.service;

import com.demirr.eticaret.constants.PaymentType;
import com.demirr.eticaret.dto.request.PaymentRequest;
import com.demirr.eticaret.entities.Payment;

public interface PaymentService {

    Payment createPayment(Long customerId, int toplamTutar, PaymentType paymentType);

    Payment getPaymentByCustomerId(Long customerId);

    Payment savePayment(PaymentRequest paymentRequest);
}
