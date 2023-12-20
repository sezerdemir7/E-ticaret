package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.dto.request.StoreRequest;
import com.demirr.eticaret.entities.Store;
import com.demirr.eticaret.repository.StoreRepository;
import com.demirr.eticaret.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;

    public StoreServiceImpl(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    public Store createStore(StoreRequest request) {
        Store store = new Store();
        store.setName(request.getName());
        store.setSellerId(request.getSellerId());
        return storeRepository.save(store);
    }


    public Store getStoreById(Long id) {
        return storeRepository.findById(id).orElseThrow();
    }

    public List<Store> getAllStore(){
        return storeRepository.findAll();
    }
}
