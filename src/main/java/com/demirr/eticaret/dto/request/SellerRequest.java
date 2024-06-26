package com.demirr.eticaret.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SellerRequest {
    @NotBlank(message = "seller name alani bos olamaz")
    @Size(min = 3,max=20,message = "name en az 3 ,en fazla 20 karakter olmalidir")
    private String name;
    @NotBlank(message = "email alani bos olamaz")
    @Email(message = "gecerli email alani giriniz")
    private String mail;
    @NotBlank(message = "sifre alani bos olamaz")
    @Size(min = 4,max = 8,message = "sifre alani en az 4, en fazla 8 karakter olmalidir")
    private String sifre;


}
