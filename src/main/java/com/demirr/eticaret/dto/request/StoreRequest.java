package com.demirr.eticaret.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StoreRequest {
    @NotBlank(message = "store name bos olamaz")
    @Size(min = 3,max =50,message = "store name en az 3, en fazla 50 karakter olmalidir")
    private String name;
    @NotNull(message = "Seller id bos olamaz")
    private Long sellerId;
}
