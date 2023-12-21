package com.demirr.eticaret.repository;

import com.demirr.eticaret.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends JpaRepository<Order,Long> {

    Optional<Order> findByCustomerId(Long id);
    List<Order> findByCustomerIdAndStatus(Long customerId, boolean status);
}
