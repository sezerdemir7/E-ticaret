package com.demirr.eticaret.repository;

import com.demirr.eticaret.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {

    Optional<CartItem> findCartItemByCartId(Long id);

    List<CartItem> findCartItemByCustomerId(Long id);
    CartItem getById(Long id);

    @Query("SELECT ci FROM CartItem ci " +
            "WHERE ci.customer.id = :customerId AND ci.product.id = :productId")
    Optional<CartItem> findByCustomerIdAndProductId(@Param("customerId") Long customerId,
                                                    @Param("productId") Long productId);


    void deleteByProductIdAndCustomerId(@Param("customerId") Long customerId,
                                        @Param("productId") Long productId);

    //void merge(CartItem cartItem);

}
