package com.demirr.eticaret.controller;

import com.demirr.eticaret.dto.request.ProductRequest;
import com.demirr.eticaret.dto.request.UpdateProductRequest;
import com.demirr.eticaret.dto.response.ProductResponse;
import com.demirr.eticaret.entities.Product;
import com.demirr.eticaret.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<ProductResponse> saveProduct(@RequestBody ProductRequest productRequest) {
        return new ResponseEntity<>(productService.saveProduct(productRequest), HttpStatus.CREATED);
    }

    @GetMapping()
    public List<ProductResponse> getAllProduct() {
        return productService.getAllProduct();
    }

    @GetMapping("/{productname}")
    public ResponseEntity<List<ProductResponse>> getProductByName(@RequestParam String name) {
        List<ProductResponse> productResponseList = productService.getProductByName(name);
        return ResponseEntity.ok(productResponseList);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductResponse> updateProductByProductId(@RequestParam Long id,
                                                                    @Valid @RequestBody UpdateProductRequest request) {
        return new ResponseEntity<>(productService.updateProductById(id, request), OK);
    }

    @GetMapping("/category/{categoryname}")
    public ResponseEntity<List<ProductResponse>> getProductByCategoryName(@RequestParam String categoryName) {
        return new ResponseEntity<>(productService.getProductByCategoryName(categoryName), OK);
    }


}
