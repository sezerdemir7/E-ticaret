package com.demirr.eticaret.entities;

import com.demirr.eticaret.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "stores")
@Getter
@Setter
public class Store extends BaseEntity {


    @NotBlank(message = "store name bos olamaz")
    @Size(min = 3,max =50,message = "store name en az 3, en fazla 50 karakter olmalidir")
    private String name;
    @OneToOne
    @JoinColumn(name = "seller_id",nullable = false)
    private Seller seller;
    @OneToMany(mappedBy = "store")
    private Set<Product> products;


}



