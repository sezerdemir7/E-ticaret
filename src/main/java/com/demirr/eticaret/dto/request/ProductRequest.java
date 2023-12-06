package com.demirr.eticaret.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    private String name;
    private int fiyat;
    private int Stok;
    private Long categoryId;
    private Long storeId;

}
