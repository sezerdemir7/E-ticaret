package com.demirr.eticaret.entities;

import com.demirr.eticaret.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cart_items")
@Getter
@Setter
public class CartItem extends BaseEntity {

    @Min(value = 0,message = "adet sayisi 0 dan büyük olamlidir")
    private int adet;
    @Min(value = 0,message = "toplam fiyat sayisi 0 dan büyük olamlidir")
    private int toplamFiyat;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id", referencedColumnName = "id")
    private Store store;

}
