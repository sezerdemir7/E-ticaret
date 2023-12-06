package com.demirr.eticaret.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavoriteCreateRequest {
    private Long customerId;
    private Long productId;
}
