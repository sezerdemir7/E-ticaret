package com.demirr.eticaret.entities;

import com.demirr.eticaret.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "stores")
@Getter
@Setter
public class Store extends BaseEntity {


    private String name;

    @JoinColumn(name = "Seller_Id")
    private Long sellerId;



}

/*
 @ManyToMany
    @JoinTable(
            name = "store_products",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private Set<Product> products;

    @OneToMany(mappedBy = "store")
    private Set<Order> orders;

    @Column(name = "Seller_id",nullable = false)
    private Long sellerId;
 */

