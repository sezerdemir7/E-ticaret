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

    private String firstName;

    private String lastName;

    private String email;

    private String sifre;

    private String adres;
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    @JsonIgnore
    private Cart cart;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Order> orders;


}

