package com.demirr.eticaret.dto.response;

import com.demirr.eticaret.entities.OrderDetail;
import lombok.Data;

@Data
public class OrderDetailResponse {
    private int adet;
    private int siparisFiyati;
    private String productname;
    private String storename;


    public OrderDetailResponse(OrderDetail orderDetail) {
        this.adet = orderDetail.getAdet();
        this.siparisFiyati = orderDetail.getSiparisFiyati();
        this.productname = orderDetail.getProduct().getName();
        this.storename=orderDetail.getProduct().getStore().getName();
    }
}
