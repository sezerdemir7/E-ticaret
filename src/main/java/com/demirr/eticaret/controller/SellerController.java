package com.demirr.eticaret.controller;

import com.demirr.eticaret.dto.request.SellerRequest;
import com.demirr.eticaret.dto.response.SellerResponse;
import com.demirr.eticaret.entities.Seller;
import com.demirr.eticaret.service.SellerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/seller")
public class SellerController {
    private SellerService sellerService;

    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    public List<SellerResponse> getAllSeller(){
        return sellerService.getAllSeller();
    }

    @PostMapping()
    public ResponseEntity<Seller> saveSeller(@RequestBody SellerRequest request){
        return new ResponseEntity<>(sellerService.saveSeller(request), CREATED);
    }





}
