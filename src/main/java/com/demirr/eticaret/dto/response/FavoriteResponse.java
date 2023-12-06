package com.demirr.eticaret.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FavoriteResponse {

    private Long id;
    private Long customerId;
    private Long productId;


    public FavoriteResponse(Long id, Long customerId, Long productId) {
        this.id = id;
        this.customerId = customerId;
        this.productId = productId;
    }
}
