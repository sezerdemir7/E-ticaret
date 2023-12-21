package com.demirr.eticaret.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class OrderResponse {
    private String teslimatAdresi;
    private String durum;
    private int toplamTutar;

    private Date orderDate;


    public OrderResponse(String teslimatAdresi,int toplamTutar,String durum,Date orderDate) {
        this.teslimatAdresi = teslimatAdresi;
        this.toplamTutar = toplamTutar;
        this.durum=durum;
        this.orderDate=orderDate;
    }
}
