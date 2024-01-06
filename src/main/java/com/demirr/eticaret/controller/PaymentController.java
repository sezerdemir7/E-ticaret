package com.demirr.eticaret.controller;

import com.demirr.eticaret.dto.request.PaymentRequest;
import com.demirr.eticaret.entities.Payment;
import com.demirr.eticaret.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    @PostMapping
    public Payment savePayment(@RequestBody PaymentRequest paymentRequest){

      return paymentService.savePayment(paymentRequest);
    }
}
