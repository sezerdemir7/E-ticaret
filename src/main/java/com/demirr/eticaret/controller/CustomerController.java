package com.demirr.eticaret.controller;

import com.demirr.eticaret.dto.request.CreateCustomerRequest;
import com.demirr.eticaret.dto.response.CustomerResponse;
import com.demirr.eticaret.entities.Customer;
import com.demirr.eticaret.exception.customerexception.CustomerNotFoundException;
import com.demirr.eticaret.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public List<CustomerResponse> getAllCustomer() {
        return customerService.getAllCustomer();
    }

    @PostMapping()
    public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody CreateCustomerRequest request) {
        return new ResponseEntity<>(customerService.createCustomer(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public CustomerResponse getOneCustomer(@PathVariable Long id) {
        return customerService.getOneCustomerById(id);
    }

    @PutMapping("/updateadres/{id}")
    public ResponseEntity<CustomerResponse> updateCustomerAdres(@PathVariable Long id,@Valid @RequestBody String adres) {
        return new ResponseEntity<>(customerService.updateCustomerAdres(id, adres),HttpStatus.OK) ;
    }

    @DeleteMapping("/deletecustomer/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable Long id) {
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
