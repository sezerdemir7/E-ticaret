package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.dto.request.SellerRequest;
import com.demirr.eticaret.entities.Seller;
import com.demirr.eticaret.repository.SellerRepository;
import com.demirr.eticaret.service.SellerService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SellerServiceImpl implements SellerService {
    private final SellerRepository sellerRepository;

    public SellerServiceImpl(SellerRepository sellerRepository) {
        this.sellerRepository = sellerRepository;
    }

    public Seller saveSeller(SellerRequest request) {
        Seller seller=new Seller();
        seller.setName(request.getName());
        seller.setSifre(request.getSifre());
        seller.setEmail(request.getMail());

        return sellerRepository.save(seller);
    }

    public Optional<String> getSellerNameById(Long id){
        return sellerRepository.findNameById(id);
    }
}
