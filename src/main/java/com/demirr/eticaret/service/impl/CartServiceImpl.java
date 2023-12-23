package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.dto.response.CartResponse;
import com.demirr.eticaret.entities.Cart;
import com.demirr.eticaret.entities.CartItem;
import com.demirr.eticaret.entities.Customer;
import com.demirr.eticaret.entities.Store;
import com.demirr.eticaret.repository.CartRepository;
import com.demirr.eticaret.service.CartService;
import com.demirr.eticaret.service.CustomerService;
import com.demirr.eticaret.service.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CustomerService customerService;
    private final StoreService storeService;


    public CartServiceImpl(CartRepository cartRepository, CustomerService customerService, StoreService storeService) {
        this.cartRepository = cartRepository;
        this.customerService = customerService;
        this.storeService = storeService;
    }

    public Cart addCartItemToCart(CartItem cartItem) {

        Customer customer = customerService.getCustomer(cartItem.getCustomer().getId());
        Cart cart = getCartByCostumerId(cartItem.getCustomer().getId());
        double totalPrice=0;

        cart.getCartItems().add(cartItem);
        for (CartItem itemSet:cart.getCartItems()) {
            totalPrice +=itemSet.getToplamFiyat();
        }
        cart.setTotalPrice(totalPrice);
        Cart tosave=saveCart(cart);

        return tosave;

    }


    /*public Optional<CartItem> getCartById(Long cartId) {
        return cartItemService.getCartItemByCartId(cartId);
    }

     */

    public Cart getOneCartById(Long cartId) {
        return cartRepository.findById(cartId).orElseThrow(() -> new RuntimeException("cart bulunamadı"));
    }

    public List<Cart> getAllCart() {
        return cartRepository.findAll();
    }

    public List<CartResponse> getCustomerCartByCustomerId(Long customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId).orElse(new Cart());
        Set<CartItem> cartItems = cart.getCartItems();


        List<CartResponse> cartResponses = cartItems.stream()
                .map(cartItem -> new CartResponse(
                        cartItem.getProduct().getName(),
                        cartItem.getAdet(),
                        cartItem.getProduct().getFiyat(),
                        cartItem.getToplamFiyat()))
                .collect(Collectors.toList());

        return cartResponses;
    }

    public Cart getCartByCostumerId(Long customerId) {
        Cart cart = cartRepository.findByCustomerId(customerId).orElse(new Cart());
        if (cart == null) {
            Customer customer = customerService.getCustomer(customerId);
            cart.setCustomer(customer);
        }
        return cart;
    }

    public Cart saveCart(Cart cart) {
        return cartRepository.save(cart);
    }

    /*public Cart addCartItemToCart(Long customerId, CartItem cartItem) {

        Customer customer = customerService.getCustomer(customerId);
        Cart cart = getCartByCostumerId(customerId);

        cartItem.setCart(cart);
        cart.setStoreId(cartItem.getStoreId());
        if (cart.getCartItems() == null) {
            cart.setCartItems((Set<CartItem>) cartItem);
        } else {
            cart.getCartItems().add(cartItem);
        }

        Cart saveCart = saveCart(cart);

        customer.setCart(saveCart);

        return saveCart;

    }*/

    public Cart getCartByCustomerId(Long customerId) {
        return cartRepository.findByCustomerId(customerId).orElse(new Cart());
    }

    public Cart createCartByCustomerId(Customer customer, Long storeId) {
        Cart newCart = new Cart();
        Store store=storeService.getOneStoreById(storeId);
        newCart.setCustomer(customer);
        newCart.setStore(store);
        return cartRepository.save(newCart);
    }
}
