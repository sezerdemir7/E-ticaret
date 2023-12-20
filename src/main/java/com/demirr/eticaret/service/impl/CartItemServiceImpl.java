package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.dto.request.CartItemRequest;
import com.demirr.eticaret.dto.response.CartItemResponse;
import com.demirr.eticaret.entities.CartItem;
import com.demirr.eticaret.entities.Customer;
import com.demirr.eticaret.entities.Product;
import com.demirr.eticaret.repository.CartItemRepository;
import com.demirr.eticaret.service.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class CartItemServiceImpl implements CartItemService {
    private final CartItemRepository cartItemRepository;
    private final ProductService productService;
    private final CartService cartService;
    private final ShoppingCartService shoppingCartService;
    private final CustomerService customerService;


    public CartItemServiceImpl(CartItemRepository cartItemRepository, ProductService productService, CartService cartService,
                               ShoppingCartService shoppingCartService, CustomerService customerService) {
        this.cartItemRepository = cartItemRepository;
        this.productService = productService;
        this.cartService = cartService;
        this.shoppingCartService = shoppingCartService;
        this.customerService = customerService;
    }

    public CartItem save(CartItem cartItem){
        return cartItemRepository.save(cartItem);
    }

    public CartItemResponse saveCartItem(CartItemRequest request){
        Product product = productService.getOneProductById(request.getProductId());
        Customer customer = customerService.getCustomer(request.getCustomerId());

        if (customer.getCart()==null) {
            cartService.createCartByCustomerId(customer, product.getStoreId());

        }

        int toplamFiyat = request.getAdet() * product.getFiyat();

        CartItem cartItem = cartItemRepository.findByCustomerIdAndProductId(request.getCustomerId(), request.getProductId())
                .orElse(null);

        if (cartItem != null) {

            cartItem.setAdet(request.getAdet());
            cartItem.setToplamFiyat(toplamFiyat);
            //cartItem.setStoreId(product.getStoreId());
            cartItem.setCart(customer.getCart());
            cartItemRepository.save(cartItem);
        } else {

            cartItem = new CartItem();
            cartItem.setAdet(request.getAdet());
            cartItem.setCustomerId(request.getCustomerId());
            cartItem.setProduct(product);
            cartItem.setCart(customer.getCart());
            cartItem.setToplamFiyat(toplamFiyat);
           // cartItem.setStoreId(product.getStoreId());
            cartItemRepository.save(cartItem);
        }



        shoppingCartService.addProductToCart(cartItem);

        return new CartItemResponse(cartItem.getAdet(), product.getId(), cartItem.getToplamFiyat(),
                Optional.ofNullable(product.getName()));

    }



    public List<CartItemResponse> getCartItemById(Long id){
        Optional<CartItem> cartItem = cartItemRepository.findById(id);

        return cartItem.stream().map((t) -> new CartItemResponse(t.getAdet(), t.getProduct().getId(), t.getToplamFiyat(),
                Optional.ofNullable(productService.getProductNameById(t.getProduct().getId())))).collect(Collectors.toList());
    }

    public CartItem getOneCartItemById(Long id){
        return cartItemRepository.findById(id).orElseThrow();
    }

    public Optional<CartItem> getCartItemByCartId(Long cartId){
        return cartItemRepository.findCartItemByCartId(cartId);
    }




    public int getTotalCartPrice(List<CartItem> cartItemsList){
        int totalCartPrice = 0;

        for (CartItem cartItem : cartItemsList) {
            totalCartPrice += (cartItem.getToplamFiyat());
        }
        return totalCartPrice;
    }



    @Override
    public void deleteCartItemByCustomerIdAndProductId(Long customerId, Long productId) {
        cartItemRepository.deleteByProductIdAndCustomerId(customerId,productId);
    }

    public void deleteCartItem(CartItem cartItem){
        cartItemRepository.delete(cartItem);
    }


    public List<CartItemResponse> getCartItemByCustomerId(Long customerId) {
        List<CartItem> cartItems= cartItemRepository.findCartItemByCustomerId(customerId);
        return cartItems.stream().map((t) -> new CartItemResponse(t.getAdet(), t.getProduct().getId(), t.getToplamFiyat(),
                Optional.ofNullable(productService.getProductNameById(t.getProduct().getId())))).collect(Collectors.toList());
    }
}
