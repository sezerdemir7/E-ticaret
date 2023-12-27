package com.demirr.eticaret.service.impl;

import com.demirr.eticaret.dto.response.CartResponse;
import com.demirr.eticaret.entities.Cart;
import com.demirr.eticaret.entities.CartItem;
import com.demirr.eticaret.entities.Customer;
import com.demirr.eticaret.entities.Store;
import com.demirr.eticaret.repository.CartRepository;
import com.demirr.eticaret.service.CartService;
import com.demirr.eticaret.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final CustomerService customerService;



    public CartServiceImpl(CartRepository cartRepository, CustomerService customerService) {
        this.cartRepository = cartRepository;
        this.customerService = customerService;

    }

    public Cart addCartItemToCart(CartItem cartItem) {

        Cart cart = getCartByCostumerId(cartItem.getCustomer().getId());
        cart.getCartItems().add(cartItem);
        double totalPrice = cart.getTotalPrice();
        totalPrice +=cartItem.getToplamFiyat();
        cart.setTotalPrice(totalPrice);
        cart.setStore(cartItem.getStore());
        Cart tosave = saveCart(cart);

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


    public Cart getCartByCustomerId(Long customerId) {
        return cartRepository.findByCustomerId(customerId).orElse(new Cart());
    }

    public Cart createCartByCustomerId(Customer customer,Store store) {
        Cart newCart = new Cart();
        newCart.setCustomer(customer);
        newCart.setStore(store);
        return cartRepository.save(newCart);
    }


    public void updateCart(Cart cart) {
        cart.setCartItems(null);
        cart.setTotalPrice(0);
        cart.setStore(null);
        cartRepository.save(cart);
    }


    public void deleteCartByCartId(Long id) {
        cartRepository.deleteById(id);
    }
}
