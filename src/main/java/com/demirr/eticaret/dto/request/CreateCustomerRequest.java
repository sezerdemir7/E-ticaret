package com.demirr.eticaret.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreateCustomerRequest {
    @NotBlank(message = "firstname boş olamaz")
    @Size(min = 2, max = 50, message = "firstname en az 2, en fazla 50 karakter olmalidir")
    private String firstname;
    @NotBlank(message = "lastname boş olamaz")
    @Size(min = 2, max = 50, message = "lastname en az 2, en fazla 50 karakter olmalidir")
    private String lastname;
    @NotBlank(message = "email boş olamaz")
    @Email(message = "geçerli bir email yaziniz")
    private String email;
    @NotBlank(message = "sifre bos olamaz")
    @Size(min = 4, max = 8, message = "sifre en az 4, en fazla 8 karakter olmalidir")
    private String sifre;
    @NotBlank(message = "adres boş olamaz")
    @Size(min = 10, max = 100, message = "adres en az 10,en fazla 100 karakter olmalidir")
    private String adress;

}
