package com.demirr.eticaret.repository;

import com.demirr.eticaret.entities.Kargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KargoRespository extends JpaRepository<Kargo,Long> {

    Kargo findByCustomerId(Long customerId);
}
