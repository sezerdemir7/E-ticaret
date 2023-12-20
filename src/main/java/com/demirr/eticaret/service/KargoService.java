package com.demirr.eticaret.service;

import com.demirr.eticaret.entities.Kargo;

public interface KargoService {

    Kargo createKargo(Long customerId, String teslimatAdresi);

    Kargo getOneKargoByCustomerId(Long customerId);

}