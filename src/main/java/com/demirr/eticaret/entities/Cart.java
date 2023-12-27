package com.demirr.eticaret.entities;

import com.demirr.eticaret.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "carts")
@Getter
@Setter

public class Cart extends BaseEntity {


    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "Store_Id")
    private Store store;
    @Min(value = 0, message = "totalprice 0 dan buyuk olmalidir")
    private double totalPrice;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.REMOVE)
    private Set<CartItem> cartItems;

    public Cart() {
        this.cartItems = new HashSet<>();
    }


}
