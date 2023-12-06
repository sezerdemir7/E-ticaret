package com.demirr.eticaret.controller;

import com.demirr.eticaret.dto.request.FavoriteCreateRequest;
import com.demirr.eticaret.dto.response.FavoriteResponse;
import com.demirr.eticaret.entities.Favorite;
import com.demirr.eticaret.service.FavoriteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/favoriler")
public class FavoriteController {
    private final FavoriteService favoriteService;

    public FavoriteController(FavoriteService favoriteService) {
        this.favoriteService = favoriteService;
    }


    @GetMapping
    public List<FavoriteResponse> getAllLikes(@RequestParam Optional<Long> customerId,
                                              @RequestParam Optional<Long> productId){

        return favoriteService.getAllLikesWithParam(customerId,productId);
    }

    @PostMapping()
    public Favorite createOneFavorite(@RequestBody FavoriteCreateRequest request){
        return favoriteService.createOneFavorite(request);
    }

    @GetMapping("/{favoriteId}")
    public FavoriteResponse getOneFavorite(@PathVariable Long favoriteId){
        return favoriteService.getOneFavoriteById(favoriteId);
    }

    @DeleteMapping("/{favoriteId}")
    public void deleteOneFavorite(@PathVariable Long favoriteId){
        favoriteService.deleteOneFavoriteById(favoriteId);
    }
}
