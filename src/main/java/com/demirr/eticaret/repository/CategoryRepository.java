package com.demirr.eticaret.repository;

import com.demirr.eticaret.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Long> {

    Optional<String> findNameById(Long id);
}
