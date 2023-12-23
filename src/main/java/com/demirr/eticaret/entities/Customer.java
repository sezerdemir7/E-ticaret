package com.demirr.eticaret.entities;

import com.demirr.eticaret.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@Getter
@Setter
public class Customer extends BaseEntity {
    @NotBlank(message = "firstname boş olamaz")
    @Size(min = 2, max = 50, message = "firstname en az 2, en fazla 50 karakter olmalidir")
    private String firstName;
    @NotBlank(message = "lastname boş olamaz")
    @Size(min = 2, max = 50, message = "lastname en az 2, en fazla 50 karakter olmalidir")
    private String lastName;
    @NotBlank(message = "email boş olamaz")
    @Email(message = "geçerli bir email yaziniz")
    private String email;
    @NotBlank(message = "sifre bos olamaz")
    @Size(min = 4,max = 8,message = "sifre en az 4, en fazla 8 karakter olmalidir")
    private String sifre;
    @NotBlank(message = "adres boş olamaz")
    @Size(min = 10,max = 100,message = "adres en az 10,en fazla 100 karakter olmalidir")
    private String adres;
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private Cart cart;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;


}

