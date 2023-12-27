package com.demirr.eticaret.controller;

import com.demirr.eticaret.dto.request.StoreRequest;
import com.demirr.eticaret.dto.response.StoreResponse;
import com.demirr.eticaret.entities.Store;
import com.demirr.eticaret.exception.storeexception.StoreNotFoundException;
import com.demirr.eticaret.service.StoreService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@RestController
@RequestMapping("/store")
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @GetMapping("/getAllStore")
    public ResponseEntity<List<Store>> getAllStore(){
        return new ResponseEntity<>(storeService.getAllStore(),HttpStatus.OK);
    }

    @PostMapping("/saveStore")
    public ResponseEntity<Store> createStore(@Valid @RequestBody StoreRequest request){
        return new ResponseEntity<>(storeService.createStore(request), HttpStatus.CREATED);
    }
    @GetMapping("/getStoreById")
    public ResponseEntity<Store> getStoreById(@RequestParam Long id){
        return new ResponseEntity<>(storeService.getOneStoreById(id),HttpStatus.OK);
    }







}
