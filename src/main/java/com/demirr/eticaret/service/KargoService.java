package com.demirr.eticaret.service;

import com.demirr.eticaret.entities.Kargo;
import com.demirr.eticaret.entities.Order;

public interface KargoService {

    Kargo createKargo(Long customerId, Order order);


}
