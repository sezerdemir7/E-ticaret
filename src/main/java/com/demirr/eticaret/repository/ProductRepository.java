package com.demirr.eticaret.repository;

import com.demirr.eticaret.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByNameContainingIgnoreCase(String name);
    List<Product> findByCategoryNameContainingIgnoreCase(String name);

    @Query("SELECT p.name FROM Product p WHERE p.id = :id")
    Optional<String> findNameById(@Param("id") Long id);

}
