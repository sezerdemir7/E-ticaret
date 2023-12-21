package com.demirr.eticaret.dto.response;

import com.demirr.eticaret.entities.Seller;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SellerResponse {
    private String name;
    private String email;

    public SellerResponse(Seller seller) {
        this.name=seller.getName();
        this.email= seller.getEmail();
    }
}
