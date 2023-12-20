package com.demirr.eticaret.controller;

import com.demirr.eticaret.dto.request.StoreRequest;
import com.demirr.eticaret.entities.Store;
import com.demirr.eticaret.service.StoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping
    public ResponseEntity<List<Store>> getAllStore(){
        return new ResponseEntity<>(storeService.getAllStore(),HttpStatus.OK);
    }

    @PostMapping("/saveStore")
    public ResponseEntity<Store> createStore(@RequestBody StoreRequest request){
        return new ResponseEntity<>(storeService.createStore(request), HttpStatus.CREATED);
    }
    @GetMapping("/getStore")
    public ResponseEntity<Store> getStoreById(@RequestParam Long id){
        return new ResponseEntity<>(storeService.getStoreById(id),HttpStatus.OK);
    }





}