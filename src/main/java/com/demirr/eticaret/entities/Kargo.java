package com.demirr.eticaret.entities;

import com.demirr.eticaret.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

@Entity
@Table(name = "kargo")
@Getter
@Setter
public class Kargo extends BaseEntity {

    @JoinColumn(name = "Customer_Id")
    private Long customerId;
    private String teslimatAdresi;
    private LocalDate tahminiTaslimat;


}
