package com.demirr.eticaret.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FavoriteCreateRequest {
    @NotNull(message = "customer id alani bos olamaz")
    private Long customerId;
    @NotNull(message = "product id alani bos olamaz")
    private Long productId;
}
