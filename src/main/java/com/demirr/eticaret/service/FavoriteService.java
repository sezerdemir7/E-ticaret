package com.demirr.eticaret.service;

import com.demirr.eticaret.dto.request.FavoriteCreateRequest;
import com.demirr.eticaret.dto.response.FavoriteResponse;
import com.demirr.eticaret.entities.Favorite;

import java.util.List;
import java.util.Optional;

public interface FavoriteService {

    List<FavoriteResponse> getAllFavoritesWithParam(Optional<Long> customerId, Optional<Long> productId);

    FavoriteResponse createOneFavorite(FavoriteCreateRequest request);

    FavoriteResponse getOneFavoriteById(Long favoriteId);

    void deleteOneFavoriteById(Long favoriteId);

}
