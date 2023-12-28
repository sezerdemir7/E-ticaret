package com.demirr.eticaret.entities;

import com.demirr.eticaret.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "stores")
@Getter
@Setter
public class Store extends BaseEntity {



    private String name;
    @OneToOne
    @JoinColumn(name = "seller_id",nullable = false)
    private Seller seller;
    @OneToMany(mappedBy = "store")
    private Set<Product> products;

    @OneToMany
    private List<Order> orders;


}



