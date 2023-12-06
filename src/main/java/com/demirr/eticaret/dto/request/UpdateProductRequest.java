package com.demirr.eticaret.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductRequest {
    private int stok;
    private int fiyat;
}
