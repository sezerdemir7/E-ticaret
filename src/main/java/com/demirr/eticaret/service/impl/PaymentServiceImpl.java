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
    private final PaymentFactoryService creditCartService;
    private final PaymentFactoryService debitCartService;
    private final PaymentFactoryService paypalAdapterService;

    public PaymentServiceImpl(PaymentRepository paymentRepository, CustomerService customerService,
                              CreditCartService creditCartService, DebitCartService debitCartService,
                              PaymentFactoryService paypalAdapterService) {
        this.paymentRepository = paymentRepository;
        this.customerService = customerService;
        this.creditCartService = creditCartService;
        this.debitCartService = debitCartService;
        this.paypalAdapterService = paypalAdapterService;
    }

    public Payment createPayment(Long customerId, int toplamTutar,PaymentType paymentType){
        Customer customer=customerService.getCustomer(customerId);
        Payment toSave=new Payment();
        toSave.setCustomer(customer);
        toSave.setOdenenTutar(toplamTutar);
        toSave.setPaymentType(paymentType);

        if(paymentType== PaymentType.CREDIT_CARD){
            creditCartService.validate();
        } else if (paymentType==PaymentType.DEBIT_CARD) {
            debitCartService.validate();
        } else if (paymentType==PaymentType.PAY_PAL) {
            paypalAdapterService.validate();

        } else {
            throw new PaymentTypeNotFoundException("Gecersiz ödeme tipi");
        }
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

        if(paymentRequest.getPaymentType()== PaymentType.CREDIT_CARD){
            creditCartService.validate();
        } else if (paymentRequest.getPaymentType()==PaymentType.DEBIT_CARD) {
            debitCartService.validate();
        } else if (paymentRequest.getPaymentType()==PaymentType.PAY_PAL) {
            paypalAdapterService.validate();

        } else {
            throw new PaymentTypeNotFoundException("Gecersiz odemi tipi");
        }

        return paymentRepository.save(payment);
    }
}
