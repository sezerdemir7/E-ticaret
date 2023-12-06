package com.demirr.eticaret.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponse {
    private String teslimatAdresi;
    private String durum;
    private int toplamTutar;

    public OrderResponse(String teslimatAdresi,int toplamTutar,String durum) {
        this.teslimatAdresi = teslimatAdresi;
        this.toplamTutar = toplamTutar;
        this.durum=durum;
    }
}
