package com.demirr.eticaret.constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum Categories {
    ELEKTRONIK("Elektronik"),
    GIYIM("Giyim"),
    KITAP("Kitap"),
    EV_ALETLERI("Ev Aletleri"),
    SPOR("Spor"),
    OYUNCAK("Oyuncak"),
    GÜZELLİK("Güzellik");

    private  String görünenAd;


}
