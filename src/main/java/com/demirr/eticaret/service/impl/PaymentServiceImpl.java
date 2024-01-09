package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.constants.PaymentType;
import com.demirr.eticaret.dto.request.PaymentRequest;
import com.demirr.eticaret.entities.Customer;
import com.demirr.eticaret.entities.Payment;
import com.demirr.eticaret.exception.paymentexception.PaymentTypeNotFoundException;
import com.demirr.eticaret.repository.PaymentRepository;
import com.demirr.eticaret.service.CustomerService;
import com.demirr.eticaret.service.PaymentFactoryService;
import com.demirr.eticaret.service.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final CustomerService customerService;
    private  PaymentFactoryService paymentFactory;


    public PaymentServiceImpl(PaymentRepository paymentRepository, CustomerService customerService) {
        this.paymentRepository = paymentRepository;
        this.customerService = customerService;

    }

    public Payment createPayment(Long customerId, int toplamTutar,PaymentType paymentType){
        Customer customer=customerService.getCustomer(customerId);


        paymentFactory=PaymentTypeFactorServiceImpl.getInstance(paymentType);
        paymentFactory.validate();

        Payment toSave=new Payment();
        toSave.setCustomer(customer);
        toSave.setOdenenTutar(toplamTutar);
        toSave.setPaymentType(paymentType);

        return paymentRepository.save(toSave);
    }

    public Payment getPaymentByCustomerId(Long customerId){
        return paymentRepository.findByCustomerId(customerId);
    }


    public Payment savePayment(PaymentRequest paymentRequest) {
        Customer customer=customerService.getCustomer(paymentRequest.getCustomerId());
        Payment payment = new Payment();
        payment.setCustomer(customer);
        payment.setPaymentType(paymentRequest.getPaymentType());
        payment.setOdenenTutar(paymentRequest.getOdenecekTutar());

        return paymentRepository.save(payment);
    }
}
