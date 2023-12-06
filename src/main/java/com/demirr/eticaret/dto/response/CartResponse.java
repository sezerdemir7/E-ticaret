package com.demirr.eticaret.dto.response;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.Primary;

@Getter
@Setter
public class CartResponse {

    private String productName;

    private int adet;
    private int fiyat;
    private int toplamTutar;

    public CartResponse(String productName, int adet, int fiyat, int toplamTutar) {
        this.productName = productName;
        this.adet = adet;
        this.fiyat = fiyat;
        this.toplamTutar = toplamTutar;
    }
}
