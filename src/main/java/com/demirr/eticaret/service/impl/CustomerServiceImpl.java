package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.dto.request.CreateCustomerRequest;
import com.demirr.eticaret.dto.response.CustomerResponse;
import com.demirr.eticaret.entities.Customer;
import com.demirr.eticaret.exception.customerexception.CustomerNotFoundException;
import com.demirr.eticaret.repository.CustomerRepository;
import com.demirr.eticaret.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;


    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<CustomerResponse> getAllCustomer() {
        List<Customer> customers =customerRepository.findAll();

        return customers.stream().map(CustomerResponse::new)
                .collect(Collectors.toList());
    }

    public Customer createCustomer(CreateCustomerRequest request){

        Customer newCustomer=new Customer();
        newCustomer.setFirstName(request.getFirstname());
        newCustomer.setLastName(request.getLastname());
        newCustomer.setSifre(request.getSifre());
        newCustomer.setEmail(request.getEmail());
        newCustomer.setAdres(request.getAdress());
        return customerRepository.save(newCustomer);
    }

    public Customer getCustomer(Long id){

        Customer customer= customerRepository.findById(id)
                .orElseThrow(()->new CustomerNotFoundException(" CustomerId: "+id+"hata customer bulunamadı"));
        return customer;
    }

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public CustomerResponse getOneCustomerById(Long customerId){

        CustomerResponse customerResponse=new CustomerResponse(getCustomer(customerId));
        return  customerResponse;

    }


    public ResponseEntity<Void> updateCustomerAdres(Long customerId, String adres) {
        Customer customer=getCustomer(customerId);
        customer.setAdres(adres);
        customerRepository.save(customer);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public void deleteCustomerById(Long id) {
        customerRepository.deleteById(id);
    }
}
