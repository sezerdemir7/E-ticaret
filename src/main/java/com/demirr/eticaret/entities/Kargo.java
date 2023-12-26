package com.demirr.eticaret.entities;

import com.demirr.eticaret.common.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Entity
@Table(name = "kargo")
@Getter
@Setter
public class Kargo extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id",nullable = false)
    private Customer customer;

    private String teslimatAdresi;
    private LocalDate tahminiTaslimat;


}
