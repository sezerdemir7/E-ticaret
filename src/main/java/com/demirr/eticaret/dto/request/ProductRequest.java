package com.demirr.eticaret.dto.request;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {
    @NotBlank(message = "product name alani boş olamaz")
    @Size(min = 2, max = 50, message = "product name en az 2, en fazla 50 karekter olmalidir")
    private String name;
    @Min(value = 0, message = "fiyat 0 dan buyuk olmalidir")
    private int fiyat;
    @NotBlank(message = "Stok alanı bos olamaz")
    @Size(min = 0, message = "Stok alanı 0 dan küçük olamaz")
    private int Stok;
    @NotNull(message = "Kategori alani bos olamaz")
    private Long categoryId;
    @NotNull(message = "Store alani bos olamaz")
    private Long storeId;




}
