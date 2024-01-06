package com.demirr.eticaret.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum PaymentType {
    CREDIT_CARD("Kredi Kartı"),
    DEBIT_CARD("Banka Kartı"),
    PAY_PAL("Pay Pal");

    private String description;


}
