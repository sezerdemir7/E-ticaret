package com.demirr.eticaret.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartItemRequest {

    @Min(value = 0,message = "adet sayisi 0 dan büyük olamlidir")
    private int adet;
    @NotNull(message = "Product id bos olamaz")
    private Long productId;
    @NotNull(message = "Customer id bos olamaz")
    private Long customerId;



}
