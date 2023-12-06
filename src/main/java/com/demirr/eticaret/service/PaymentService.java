package com.demirr.eticaret.service;

import com.demirr.eticaret.entities.Payment;
import com.demirr.eticaret.repository.PaymentRepository;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }


    public Payment createPayment(Long customerId,int toplamTutar){
        Payment toSave=new Payment();
        toSave.setCustomerId(customerId);
        toSave.setOdenenTutar(toplamTutar);

        return paymentRepository.save(toSave);
    }



    public Payment getPaymentByCustomerId(Long customerId){
        return paymentRepository.findByCustomerId(customerId);
    }




}



