package com.demirr.eticaret.entities;

import com.demirr.eticaret.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CurrentTimestamp;


import java.sql.Timestamp;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order extends BaseEntity {
    @NotBlank(message = "teslimat adresi boş olamaz")
    private String teslimatAdresi;
    private boolean status;
    @Min(value = 0,message = "toplam tutar 0 dan buyuk olmalidir")
    private int toplamTutar;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;
    @OneToOne
    @JoinColumn(name = "kargo_id", nullable = false)
    private Kargo kargo;
    @OneToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private Payment payment;
    @CurrentTimestamp()
    private Timestamp orderDate;

}

