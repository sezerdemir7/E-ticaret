package com.demirr.eticaret.service;

import com.demirr.eticaret.dto.request.StoreRequest;
import com.demirr.eticaret.entities.Store;

import java.util.List;

public interface StoreService {

    Store createStore(StoreRequest request);

    Store getStoreById(Long id);

    List<Store> getAllStore();

}
