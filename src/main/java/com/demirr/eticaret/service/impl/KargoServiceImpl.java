package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.entities.Kargo;
import com.demirr.eticaret.repository.KargoRespository;
import com.demirr.eticaret.service.KargoService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Service
public class KargoServiceImpl implements KargoService {
    private final KargoRespository kargoRespository;

    public KargoServiceImpl(KargoRespository kargoRespository) {
        this.kargoRespository = kargoRespository;
    }

    public Kargo createKargo(Long customerId, String teslimatAdresi){
        Kargo kargo=new Kargo();
        kargo.setCustomerId(customerId);
        kargo.setTeslimatAdresi(teslimatAdresi);
        LocalDateTime teslimatTarihi = LocalDateTime.now().plusDays(5);
        kargo.setTahminiTaslimat(LocalDate.from(teslimatTarihi));
        return kargoRespository.save(kargo);

    }

    public Kargo getOneKargoByCustomerId(Long customerId){
        Kargo kargo= kargoRespository.findByCustomerId(customerId);
        if(kargo==null){
            kargo=createKargo(customerId,"ilhan akıncı");
        }
        return kargo;
    }
}
