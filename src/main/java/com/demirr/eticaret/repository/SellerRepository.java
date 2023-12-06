package com.demirr.eticaret.repository;

import com.demirr.eticaret.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface SellerRepository extends JpaRepository<Seller,Long> {
    @Query("SELECT s.name FROM Seller s WHERE s.id = :id")
    Optional<String> findNameById(@Param("id") Long id);
}
