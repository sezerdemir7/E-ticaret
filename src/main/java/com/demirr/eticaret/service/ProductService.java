package com.demirr.eticaret.service;

import com.demirr.eticaret.dto.request.ProductRequest;
import com.demirr.eticaret.dto.request.UpdateProductRequest;
import com.demirr.eticaret.dto.response.ProductResponse;
import com.demirr.eticaret.entities.Product;

import java.util.List;

public interface ProductService {

    Product saveProduct(ProductRequest request);

    List<ProductResponse> getAllProduct();

    List<ProductResponse> getProductByName(String name);

    ProductResponse updateProductById(Long productId, UpdateProductRequest request);

    ProductResponse getProductByProduct(Product product);
    void updateProductStock(Long productId,int stok);

    Product getOneProductById(Long id);

    String getProductNameById(Long productId);

    boolean productStockControlById(Long productId,int adet);
}
