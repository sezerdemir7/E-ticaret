package com.demirr.eticaret.entities;

import com.demirr.eticaret.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;


import java.sql.Timestamp;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends BaseEntity {


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @JoinColumn(name = "store_id", nullable = false)
    private Long storeId;
    private String teslimatAdresi;
    @JoinColumn(name = "kargo_id", nullable = false)
    private Long kargoId;
    @JoinColumn(name = "payment_id", nullable = false)
    private Long paymentId;
    @CurrentTimestamp()
    private Timestamp orderDate;
    private boolean status;
    private int toplamTutar;
}

