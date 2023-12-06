package com.demirr.eticaret.entities;

import com.demirr.eticaret.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "favorite_items")
@Getter
@Setter
public class Favorite extends BaseEntity {


    @JoinColumn(name = "customer_id", nullable = false)
    private Long customerId;


    @JoinColumn(name = "product_id", nullable = false)
    private Long productId;

}
