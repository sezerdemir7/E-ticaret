package com.demirr.eticaret.repository;

import com.demirr.eticaret.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {

    Payment findByCustomerId(Long customerId);

}
