package com.demirr.eticaret.dto.request;

import lombok.Data;

@Data
public class CreateCustomerRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String sifre;

    private String adress;

}
