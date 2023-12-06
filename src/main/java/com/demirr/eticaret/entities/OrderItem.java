package com.demirr.eticaret.entities;

import com.demirr.eticaret.common.BaseEntity;
import jakarta.persistence.*;


@Entity
@Table(name = "order_items")
public class OrderItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "order_id", nullable = false)
    private Long orderId;


    @JoinColumn(name = "product_id", nullable = false)
    private Long productId;

    private int miktar;

    // Getter ve setter metotları
}
