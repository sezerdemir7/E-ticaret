package com.demirr.eticaret.controller;
import com.demirr.eticaret.dto.request.CreateCustomerRequest;
import com.demirr.eticaret.dto.response.CustomerResponse;
import com.demirr.eticaret.entities.Customer;
import com.demirr.eticaret.exception.customerexception.CustomerNotFoundException;
import com.demirr.eticaret.service.CustomerService;
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
    public ResponseEntity<Customer> saveCustomer(@RequestBody CreateCustomerRequest request) {
        return new ResponseEntity<>(customerService.createCustomer(request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public CustomerResponse getOneCustomer(@PathVariable Long id) {
        return getCustomerById(id);
    }

    public CustomerResponse getCustomerById(Long id) {
        return customerService.getOneCustomerById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCustomerAdres(@PathVariable Long id, @RequestBody String adres) {
        return customerService.updateCustomerAdres(id, adres);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomerById(@RequestParam Long id) {
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<String> handleCustomerNotFoundException(CustomerNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), NOT_FOUND);

    }


}
