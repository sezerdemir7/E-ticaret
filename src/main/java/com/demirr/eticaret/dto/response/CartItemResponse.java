package com.demirr.eticaret.dto.response;

import com.demirr.eticaret.entities.CartItem;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter

public class CartItemResponse {

    private int adet;
    private Long productId;

    private int toplamFiyat;
    private Optional<String>  productName;


    public CartItemResponse(int adet, Long productId, int toplamFiyat, Optional<String> productName) {
        this.adet = adet;
        this.productId = productId;
        this.toplamFiyat = toplamFiyat;
        this.productName = productName;
    }


}
