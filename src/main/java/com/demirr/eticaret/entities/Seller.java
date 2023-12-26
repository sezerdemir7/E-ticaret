package com.demirr.eticaret.entities;

import com.demirr.eticaret.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name = "sellers")
@Getter
@Setter
public class Seller extends BaseEntity {
    private String name;
    private String email;
    private String sifre;

}