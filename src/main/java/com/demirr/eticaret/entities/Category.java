package com.demirr.eticaret.entities;

import com.demirr.eticaret.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category extends BaseEntity {

    private String name;


}
