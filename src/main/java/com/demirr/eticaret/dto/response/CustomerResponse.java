package com.demirr.eticaret.dto.response;

import com.demirr.eticaret.entities.Customer;
import lombok.Data;

@Data
public class CustomerResponse {
    private String firstname;
    private String lastname;
    private String adres;
    private String mail;

    public CustomerResponse(Customer customer) {
        this.firstname=customer.getFirstName();
        this.lastname=customer.getLastName();
        this.mail= customer.getEmail();
        this.adres= customer.getAdres();


    }
}
