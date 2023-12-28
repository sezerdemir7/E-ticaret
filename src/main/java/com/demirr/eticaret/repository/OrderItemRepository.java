package com.demirr.eticaret.repository;

import com.demirr.eticaret.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderDetail,Long> {
}
