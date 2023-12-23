package com.demirr.eticaret.controller;

import com.demirr.eticaret.dto.request.ProductRequest;
import com.demirr.eticaret.dto.request.UpdateProductRequest;
import com.demirr.eticaret.dto.response.ProductResponse;
import com.demirr.eticaret.entities.Product;
import com.demirr.eticaret.exception.productexception.ProductNotFoundException;
import com.demirr.eticaret.exception.productexception.ProductOutOfStockException;
import com.demirr.eticaret.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public Product saveProduct(@RequestBody ProductRequest productRequest){
        return productService.saveProduct(productRequest);
    }

    @GetMapping()
    public List<ProductResponse> getAllProduct(){
        return productService.getAllProduct();
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<ProductResponse>> getProductByName(@RequestParam String name){
        List<ProductResponse> productResponseList=productService.getProductByName(name);
       return ResponseEntity.ok(productResponseList);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductResponse> updateProductByProductId(@RequestParam Long id,
                                                                    @RequestBody UpdateProductRequest request){
        return new ResponseEntity<>(productService.updateProductById(id,request), OK);
    }


    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException exception){
        return new ResponseEntity<>(exception.getMessage(), NOT_FOUND);

    }
    @ExceptionHandler(ProductOutOfStockException.class)
    public ResponseEntity<String> handleProductOutOfStockException(ProductOutOfStockException exception){
        return new ResponseEntity<>(exception.getMessage(),BAD_REQUEST);
    }






}
