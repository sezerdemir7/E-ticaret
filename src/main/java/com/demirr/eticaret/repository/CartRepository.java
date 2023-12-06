package com.demirr.eticaret.repository;

import com.demirr.eticaret.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {

    Optional<Cart> findByCustomerId(Long customerId);
}
