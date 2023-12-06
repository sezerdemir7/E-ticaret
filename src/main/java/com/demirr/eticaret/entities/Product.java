package com.demirr.eticaret.entities;

import com.demirr.eticaret.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product extends BaseEntity {



    private String name;
    private int fiyat;
    private int stok;


    @JoinColumn(name = "category_id", nullable = false)
    private Long categoryId;

    private String categoryName;

    @JoinColumn(name = "Store_Id")
    private Long storeId;
    /*
   private Long categoryId;
    /*
    @ManyToMany(mappedBy = "products")
    private Set<Store> stores;
    */



    /*@OneToMany(mappedBy = "product")
    private Set<OrderItem> orderItems;

    @OneToMany(mappedBy = "product")
    private Set<CartItem> cartItems;

     */

   /* @OneToMany(mappedBy = "product")
    private Set<Favorite> favorites;


    */

}