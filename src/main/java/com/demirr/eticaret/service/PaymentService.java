package com.demirr.eticaret.service;

import com.demirr.eticaret.entities.Payment;

public interface PaymentService {

    Payment createPayment(Long customerId, int toplamTutar);

    Payment getPaymentByCustomerId(Long customerId);

}
