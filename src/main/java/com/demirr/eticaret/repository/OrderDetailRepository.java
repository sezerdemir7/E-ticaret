package com.demirr.eticaret.repository;

import com.demirr.eticaret.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail,Long>{

    List<OrderDetail> findOrderDetailByOrderId(Long orderId);
}
