package com.demirr.eticaret.dto.response;

import com.demirr.eticaret.entities.Product;
import com.demirr.eticaret.entities.Seller;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

import java.util.List;
import java.util.Set;
@Data
public class StoreResponse {
    private String name;
    private SellerResponse seller;
    private List<ProductResponse> products;

}
