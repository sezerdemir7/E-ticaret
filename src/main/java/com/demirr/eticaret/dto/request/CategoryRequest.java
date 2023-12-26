package com.demirr.eticaret.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryRequest {
    @NotBlank(message = "name alani boş olamaz")
    @Size(min = 3,max=50,message = "name en 3 ,en fazla 50 karakter olmalidir")
    private String name;

}
