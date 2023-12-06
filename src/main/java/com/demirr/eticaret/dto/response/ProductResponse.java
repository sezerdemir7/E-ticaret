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
    private Long categoryId;

    private String categoryName;
    private int stok;
    private Long storeId;


    public ProductResponse(Long id, String name, double fiyat, Long categoryId, String categoryName, int stok, Long storeId) {
        this.id = id;
        this.name = name;
        this.fiyat = fiyat;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.stok = stok;
        this.storeId = storeId;
    }


}
