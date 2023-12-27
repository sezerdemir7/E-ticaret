package com.demirr.eticaret.dto.response;

import com.demirr.eticaret.entities.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {
    private Long id;
    private String name;
    private double fiyat;
    private String categoryName;
    private int stok;
    private String storeName;
    //private Long storeId;


    public ProductResponse(Long id, String name, double fiyat, String categoryName, int stok, String storeName) {
        this.id = id;
        this.name = name;
        this.fiyat = fiyat;
        this.categoryName = categoryName;
        this.stok = stok;
        this.storeName = storeName;
    }
}
