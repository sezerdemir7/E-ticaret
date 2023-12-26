package com.demirr.eticaret.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProductRequest {
    @NotBlank(message = "Stok alanı bos olamaz")
    @Size(min = 0,message = "Stok alanı 0 dan küçük olamaz")
    private int stok;
    @NotNull(message = "Fiyat alanı bos olamaz")
    @Size(min = 0,message = "Stok alanı 0 dan küçük olamaz")
    private int fiyat;
}
