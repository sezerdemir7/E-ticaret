package com.demirr.eticaret.entities;

import com.demirr.eticaret.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carts")
@Getter
@Setter

public class Cart extends BaseEntity {

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;


    @JoinColumn(name = "Store_Id")
    private Long storeId;


    private double totalPrice;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cart")
    private Set<CartItem> cartItems;

    public Cart() {
        this.cartItems = new HashSet<>();
    }
    /*

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private Customer customer;



    private int totalItems;

    @OneToMany(cascade = CascadeType.DETACH, mappedBy = "cart")
    private Set<CartItem> cartItems;



    //



    @ManyttoOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @OneToMany(mappedBy = "cart")
    private Set<CartItem> cartItems;
    */




}
