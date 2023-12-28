package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.dto.request.StoreRequest;
import com.demirr.eticaret.entities.Seller;
import com.demirr.eticaret.entities.Store;
import com.demirr.eticaret.exception.storeexception.StoreNotFoundException;
import com.demirr.eticaret.repository.StoreRepository;
import com.demirr.eticaret.service.SellerService;
import com.demirr.eticaret.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;
    private final SellerService sellerService;

    public StoreServiceImpl(StoreRepository storeRepository, SellerService sellerService) {
        this.storeRepository = storeRepository;
        this.sellerService = sellerService;
    }

    public Store createStore(StoreRequest request) {
        Seller seller=sellerService.getOneSellerById(request.getSellerId());
        Store store = new Store();
        store.setName(request.getName());
        store.setSeller(seller);
        return storeRepository.save(store);
    }


    public Store getOneStoreById(Long id) {
        return storeRepository.findById(id).orElseThrow(
                ()->new StoreNotFoundException("Store bulunamadi store id="+id)
        );
    }

    public List<Store> getAllStore(){
        return storeRepository.findAll();
    }


    public void updateStoreOrders(Store store) {
        Store updateStore=storeRepository.findById(store.getId()).orElseThrow(
                ()->new StoreNotFoundException("Store bulunamadi store id="+store.getId())
        );
        storeRepository.save(updateStore);

    }
}
