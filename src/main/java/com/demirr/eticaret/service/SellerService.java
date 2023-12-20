package com.demirr.eticaret.service;

import com.demirr.eticaret.dto.request.SellerRequest;
import com.demirr.eticaret.entities.Seller;

import java.util.Optional;

public interface SellerService {

    Seller saveSeller(SellerRequest request);

    Optional<String> getSellerNameById(Long id);

}
