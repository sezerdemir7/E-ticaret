package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.dto.request.ProductRequest;
import com.demirr.eticaret.dto.request.UpdateProductRequest;
import com.demirr.eticaret.dto.response.ProductResponse;
import com.demirr.eticaret.entities.Category;
import com.demirr.eticaret.entities.Product;
import com.demirr.eticaret.entities.Store;
import com.demirr.eticaret.exception.productexception.ProductNotFoundException;
import com.demirr.eticaret.exception.productexception.ProductOutOfStockException;
import com.demirr.eticaret.repository.ProductRepository;
import com.demirr.eticaret.service.CategoryService;
import com.demirr.eticaret.service.ProductService;
import com.demirr.eticaret.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final CategoryService categoryService;
    private final StoreService storeService;

    public ProductServiceImpl(ProductRepository productRepository, CategoryService categoryService, StoreService storeService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
        this.storeService = storeService;
    }

    public ProductResponse saveProduct(ProductRequest request) {
        Category category=categoryService.getOneCategoryById(request.getCategoryId());
        Store store=storeService.getOneStoreById(request.getStoreId());

        Product product = new Product();
                product.setName(request.getName());
                product.setFiyat(request.getFiyat());
                product.setStok(request.getStok());
                product.setCategory(category);
                product.setStore(store);
        return getProductResponseByProduct(productRepository.save(product));
    }

    public List<ProductResponse> getAllProduct() {

        List<Product> products=productRepository.findAll();
        return getProductResponses(products);
    }

    public List<ProductResponse> getProductByName(String name) {
        List<Product> products=productRepository.findByNameContainingIgnoreCase(name);
        return getProductResponses(products);
    }

    public List<ProductResponse> getProductByCategoryName(String name) {
        List<Product> products=productRepository.findByCategoryNameContainingIgnoreCase(name);
        return getProductResponses(products);
    }

    private  List<ProductResponse> getProductResponses(List<Product> products) {
        return products.stream().map((product) -> new ProductResponse(
                        product.getId(), product.getName(), product.getFiyat(),
                        product.getCategory().getName(),
                        product.getStok(), product.getStore().getName()))
                .collect(Collectors.toList());
    }

    public ProductResponse updateProductById(Long productId, UpdateProductRequest request){
        Product product=getOneProductById(productId);
        if(product==null){
            throw  new ProductNotFoundException("Product bulunamadi productId="+productId);
        }
        product.setStok(request.getStok());
        product.setFiyat(request.getFiyat());

        return getProductResponseByProduct(productRepository.save(product));
    }

    public void updateProductStock(Long productId,int istenenAdet){
        Product product=getOneProductById(productId);
        if(product.getStok()<istenenAdet){
            throw new ProductOutOfStockException("Prodcut stoğu yetersiz! product name:"+product.getName()
                    +" stock:"+product.getStok());
        }
        int newStock;
        newStock=product.getStok()-istenenAdet;
        product.setStok(newStock);
        productRepository.save(product);
    }

    public ProductResponse getProductResponseByProduct(Product product){
        return new ProductResponse(
                product.getId(),product.getName(),product.getFiyat(),
                product.getCategory().getName(),
                product.getStok(),product.getStore().getName());
    }

    public Product getOneProductById(Long productId){
        return productRepository.findById(productId).orElseThrow(()
                ->new ProductNotFoundException("Product bulunamadı product_id="+productId));
    }

    public String getProductNameById(Long productId){
        return productRepository.findNameById(productId).orElseThrow(()
                ->new ProductNotFoundException("Product bulunamadı"));
    }


    public boolean productStockControlById(Long productId,int adet) {
        Product product=getOneProductById(productId);
        if(product.getStok()<adet){
            throw new ProductOutOfStockException("Product stoğu yetersiz! stok="+product.getStok());
        }
        return true;
    }

}
