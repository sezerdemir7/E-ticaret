package com.demirr.eticaret.service;

import com.demirr.eticaret.dto.request.ProductRequest;
import com.demirr.eticaret.dto.request.UpdateProductRequest;
import com.demirr.eticaret.dto.response.ProductResponse;
import com.demirr.eticaret.entities.Category;
import com.demirr.eticaret.entities.Product;
import com.demirr.eticaret.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;

    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public Product saveProduct(ProductRequest request) {
        Category category=categoryService.getOneCategoryById(request.getCategoryId());
        Product product=new Product();
        product.setName(request.getName());
        product.setFiyat(request.getFiyat());
        product.setStok(request.getStok());
        product.setCategoryId(category.getId());
        product.setCategoryName(category.getName());
        product.setStoreId(request.getStoreId());
        return productRepository.save(product);
    }

    public List<ProductResponse> getAllProduct() {

        List<Product> products=productRepository.findAll();
        return  products.stream().map((product)->new ProductResponse(
                product.getId(),product.getName(),product.getFiyat(),
                product.getCategoryId(),product.getCategoryName(),product.getStok(),product.getStoreId()))
                .collect(Collectors.toList());
    }

    public List<ProductResponse> getProductByName(String name) {
        List<Product> products=productRepository.findByNameContainingIgnoreCase(name);
        return products.stream().map((product)->new ProductResponse(
                product.getId(),product.getName(),product.getFiyat(),
                product.getCategoryId(),product.getCategoryName(),product.getStok(),product.getStoreId()))
                .collect(Collectors.toList());
    }

    public ProductResponse updateProductById(Long productId, UpdateProductRequest request){
        Product product=getOneProductById(productId);
        product.setStok(request.getStok());
        product.setFiyat(request.getFiyat());

        return getProductByProdcut(productRepository.save(product));
    }

    public ProductResponse getProductByProdcut(Product product){
        return new ProductResponse(
                product.getId(),product.getName(),product.getFiyat(),
                product.getCategoryId(),product.getCategoryName(),product.getStok(),product.getStoreId());
    }

    public Product getOneProductById(Long id){
        return productRepository.findById(id).orElseThrow(() ->new RuntimeException("Product bulunamadı"));
    }

    public String getProductNameById(Long productId){
        return productRepository.findNameById(productId).orElseThrow(() ->new RuntimeException("Product bulunamadı"));
    }
}
