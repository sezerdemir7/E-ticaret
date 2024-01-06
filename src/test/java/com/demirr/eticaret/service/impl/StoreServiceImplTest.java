package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.dto.request.StoreRequest;
import com.demirr.eticaret.entities.Seller;
import com.demirr.eticaret.entities.Store;
import com.demirr.eticaret.exception.storeexception.StoreNotFoundException;
import com.demirr.eticaret.repository.StoreRepository;
import com.demirr.eticaret.service.SellerService;
import com.demirr.eticaret.service.StoreService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StoreServiceImplTest {

    private StoreService storeService;
    private StoreRepository storeRepository;
    private SellerService sellerService;

    @BeforeEach
    void setUp() {
        storeRepository= Mockito.mock(StoreRepository.class);
        sellerService=Mockito.mock(SellerService.class);

        storeService=new StoreServiceImpl(storeRepository,sellerService);
    }
    @Test
    void whencreateStore() {
        StoreRequest request=new StoreRequest();
        request.setSellerId(1L);
        request.setName("test-store");

        Seller seller=new Seller();
        seller.setName("demir");
        seller.setId(1L);

        Store expectedStore=new Store();
        //expectedStore.setId(1L);
        expectedStore.setName("test-store");
        expectedStore.setSeller(seller);

        Mockito.when(sellerService.getOneSellerById(request.getSellerId())).thenReturn(seller);
        Mockito.when(storeRepository.save(expectedStore)).thenReturn(expectedStore);

        Store result=storeService.createStore(request);

        Assertions.assertEquals(expectedStore.getId(), result.getId());
        Assertions.assertEquals(expectedStore.getName(), result.getName());
        Assertions.assertEquals(expectedStore.getSeller(), result.getSeller());


        Mockito.verify(sellerService).getOneSellerById(request.getSellerId());
        Mockito.verify(storeRepository).save(expectedStore);


    }

    @Test
    void whenGetOneStoreById_WithValidId_ThenReturnStore(){
        Long id=1L;
        Store store=new Store();
        store.setId(id);
        store.setName("test_name");

        Mockito.when(storeRepository.findById(id)).thenReturn(Optional.of(store));

        Store result=storeService.getOneStoreById(id);

        Assertions.assertEquals(result,store);
        Mockito.verify(storeRepository).findById(id);

    }

    @Test
    void whenGetOneStoreById_WithInvalidId_ThenThrowStoreNotFoundException(){
        Long storeId=1L;
        Mockito.when(storeRepository.findById(storeId)).thenReturn(Optional.empty());
        org.assertj.core.api.Assertions.assertThatThrownBy(()->storeService.getOneStoreById(storeId))
                .isInstanceOf(StoreNotFoundException.class)
                .hasMessageContaining("Store bulunamadi store id="+storeId);

    }

    @Test
    void whenGetAllStore_ThenReturnStoreList(){
        List<Store> list=new ArrayList<>();
        Store store1=new Store();
        store1.setId(1L);
        store1.setName("test_name 1");
        Store store2=new Store();
        store2.setId(2L);
        store2.setName("test_name 2");

        list.add(store1);
        list.add(store2);

        Mockito.when(storeRepository.findAll()).thenReturn(list);

        List<Store> result=storeService.getAllStore();

        Assertions.assertEquals(result,list);
        Mockito.verify(storeRepository).findAll();
    }

    @Test
    void whenUpdateStoreOrders_ThenReturnUpdatedStore(){
        Long id=1L;
        Store store=new Store();
        store.setId(id);
        store.setName("test_name");

        Mockito.when(storeRepository.findById(id)).thenReturn(Optional.of(store));
        Mockito.when(storeRepository.save(Mockito.any(Store.class))).thenAnswer(
                invocation -> invocation.getArgument(0));

        Store result=storeService.updateStoreOrders(store);

        Assertions.assertEquals(result,store);
        Mockito.verify(storeRepository).findById(id);

    }

    @Test
    void whenUpdateStoreOrders_WithNonExistingStore_ThenThrowStoreNotFoundException(){
        Long id=2L;

        Store store=new Store();
        store.setId(id);
        Mockito.when(storeRepository.findById(id)).thenReturn(Optional.empty());
        org.assertj.core.api.Assertions.assertThatThrownBy(()->storeService.updateStoreOrders(store))
                .isInstanceOf(StoreNotFoundException.class)
                .hasMessageContaining("Store bulunamadi store id="+id);
    }

    @AfterEach
    void tearDown() {

    }
}