package com.demirr.eticaret.service;

import com.demirr.eticaret.dto.request.CreateCustomerRequest;
import com.demirr.eticaret.dto.response.CustomerResponse;
import com.demirr.eticaret.entities.Customer;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CustomerService {

    List<CustomerResponse> getAllCustomer();

    Customer createCustomer(CreateCustomerRequest request);

    Customer getCustomer(Long id);

    Customer save(Customer customer);

    CustomerResponse getOneCustomerById(Long customerId);

    CustomerResponse updateCustomerAdres(Long customerId, String adres);

    void deleteCustomerById(Long id);

}
