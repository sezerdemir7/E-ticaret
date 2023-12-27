package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.entities.Customer;
import com.demirr.eticaret.entities.Kargo;
import com.demirr.eticaret.repository.KargoRespository;
import com.demirr.eticaret.service.CustomerService;
import com.demirr.eticaret.service.KargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Service
public class KargoServiceImpl implements KargoService {
    private final KargoRespository kargoRespository;
    private final CustomerService customerService;
    @Autowired
    public KargoServiceImpl(KargoRespository kargoRespository, CustomerService customerService) {
        this.kargoRespository = kargoRespository;
        this.customerService = customerService;
    }

    public Kargo createKargo(Long customerId){
        Customer customer=customerService.getCustomer(customerId);
        Kargo kargo=new Kargo();
        kargo.setCustomer(customer);
        kargo.setTeslimatAdresi(customer.getAdres());
        LocalDateTime teslimatTarihi = LocalDateTime.now().plusDays(5);
        kargo.setTahminiTaslimat(LocalDate.from(teslimatTarihi));
        return kargoRespository.save(kargo);

    }

    public Kargo getOneKargoByCustomerId(Long customerId){
        Kargo kargo= kargoRespository.findByCustomerId(customerId);
        if(kargo==null){
            kargo=createKargo(customerId);
        }
        return kargo;
    }
}
