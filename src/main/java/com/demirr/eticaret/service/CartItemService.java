package com.demirr.eticaret.service;

import com.demirr.eticaret.dto.request.CartItemRequest;
import com.demirr.eticaret.dto.response.CartItemResponse;
import com.demirr.eticaret.entities.CartItem;

import java.util.List;
import java.util.Optional;

public interface CartItemService {

    CartItem save(CartItem cartItem);

    CartItemResponse saveCartItem(CartItemRequest request);

    List<CartItemResponse> getCartItemById(Long id);

    CartItem getOneCartItemById(Long id);

    Optional<CartItem> getCartItemByCartId(Long cartId);

    int getTotalCartPrice(List<CartItem> cartItemsList);

    void deleteCartItemByCustomerIdAndProductId(Long customerId,Long productId);

    void deleteCartItem(CartItem cartItem);

    List<CartItemResponse> getCartItemByCustomerId(Long customerId);

}
