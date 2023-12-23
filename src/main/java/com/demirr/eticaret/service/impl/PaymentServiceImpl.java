package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.entities.Customer;
import com.demirr.eticaret.entities.Payment;
import com.demirr.eticaret.repository.PaymentRepository;
import com.demirr.eticaret.service.CustomerService;
import com.demirr.eticaret.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final CustomerService customerService;

    public PaymentServiceImpl(PaymentRepository paymentRepository, CustomerService customerService) {
        this.paymentRepository = paymentRepository;
        this.customerService = customerService;
    }

    public Payment createPayment(Long customerId, int toplamTutar){
        Customer customer=customerService.getCustomer(customerId);
        Payment toSave=new Payment();
        toSave.setCustomer(customer);
        toSave.setOdenenTutar(toplamTutar);

        return paymentRepository.save(toSave);
    }



    public Payment getPaymentByCustomerId(Long customerId){
        return paymentRepository.findByCustomerId(customerId);
    }
}
