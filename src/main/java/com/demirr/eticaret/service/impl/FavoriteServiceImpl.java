package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.dto.request.FavoriteCreateRequest;
import com.demirr.eticaret.dto.response.FavoriteResponse;
import com.demirr.eticaret.entities.Customer;
import com.demirr.eticaret.entities.Favorite;
import com.demirr.eticaret.entities.Product;
import com.demirr.eticaret.repository.FavoriteRepository;
import com.demirr.eticaret.service.CustomerService;
import com.demirr.eticaret.service.FavoriteService;
import com.demirr.eticaret.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class FavoriteServiceImpl implements FavoriteService {
    private final FavoriteRepository favoriteRepository;
    private final CustomerService customerService;
    private final ProductService productService;

    public FavoriteServiceImpl(FavoriteRepository favoriteRepository, CustomerService customerService, ProductService productService) {
        this.favoriteRepository = favoriteRepository;
        this.customerService = customerService;
        this.productService = productService;
    }

    public List<FavoriteResponse> getAllFavoritesWithParam(Optional<Long> customerId, Optional<Long> productId) {

        List<Favorite> list;
        if(customerId.isPresent()&& productId.isPresent()) {
            list= favoriteRepository.findByCustomerIdAndProductId(customerId.get(),productId.get());
        } else if (customerId.isPresent()) {
            list=favoriteRepository.findByCustomerId(customerId.get());
        } else if (productId.isPresent()) {
            list=favoriteRepository.findByProductId(productId.get());
        }
        else {
            list=favoriteRepository.findAll();
        }
        return list.stream().map(favorite -> new FavoriteResponse(
                favorite.getId(),
                favorite.getCustomerId(),
                favorite.getProductId()
        )).collect(Collectors.toList());
    }


    public Favorite createOneFavorite(FavoriteCreateRequest request){

        Customer customer=customerService.getCustomer(request.getCustomerId());
        Product product=productService.getOneProductById(request.getProductId());

        if(customer!=null && product!=null){
            Favorite favoriteToSave=new Favorite();
            favoriteToSave.setCustomerId(request.getCustomerId());
            favoriteToSave.setProductId(request.getProductId());

            return favoriteRepository.save(favoriteToSave);
        }
        else{
            return null;
        }
    }

    public FavoriteResponse getOneFavoriteById(Long favoriteId){
        Favorite favorite=favoriteRepository.findById(favoriteId).orElse(null);
        FavoriteResponse response=new FavoriteResponse();
        response.setId(favorite.getId());
        response.setCustomerId(favorite.getCustomerId());
        response.setProductId(favorite.getProductId());
        return response;
    }

    public void deleteOneFavoriteById(Long favoriteId){
        favoriteRepository.deleteById(favoriteId);
    }
}
