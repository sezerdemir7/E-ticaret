package com.demirr.eticaret.entities;

import com.demirr.eticaret.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "products")
@Getter
@Setter
public class Product extends BaseEntity {

    private String name;
    private int fiyat;
    private int stok;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;




}