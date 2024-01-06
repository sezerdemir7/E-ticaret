package com.demirr.eticaret.repository;

import com.demirr.eticaret.entities.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoriteRepository extends JpaRepository<Favorite,Long> {
    List<Favorite> findByCustomerIdAndProductId(Long customerId, Long productId);
    List<Favorite> findByCustomerId(Long customerId);
    List<Favorite> findByProductId(Long productId);


}
