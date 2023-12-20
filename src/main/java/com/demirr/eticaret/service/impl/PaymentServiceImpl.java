package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.entities.Payment;
import com.demirr.eticaret.repository.PaymentRepository;
import com.demirr.eticaret.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(Long customerId, int toplamTutar){
        Payment toSave=new Payment();
        toSave.setCustomerId(customerId);
        toSave.setOdenenTutar(toplamTutar);

        return paymentRepository.save(toSave);
    }



    public Payment getPaymentByCustomerId(Long customerId){
        return paymentRepository.findByCustomerId(customerId);
    }
}
