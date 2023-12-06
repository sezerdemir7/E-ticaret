package com.demirr.eticaret.service;

import com.demirr.eticaret.dto.response.CartResponse;
import com.demirr.eticaret.entities.Cart;
import com.demirr.eticaret.entities.CartItem;
import com.demirr.eticaret.entities.Customer;
import com.demirr.eticaret.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service

public class CartService {

    private final CartRepository cartRepository;
    private  final CustomerService customerService;
    private final OrderService orderService;

    public CartService(CartRepository cartRepository, CustomerService customerService, OrderService orderService) {
        this.cartRepository = cartRepository;
        this.customerService = customerService;
        this.orderService = orderService;
    }

    /*public Optional<CartItem> getCartById(Long cartId) {
        return cartItemService.getCartItemByCartId(cartId);
    }

     */

    public Cart getOneCartById(Long cartId){
        return cartRepository.findById(cartId).orElseThrow(()->new RuntimeException("cart bulunamadı"));
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

    public Cart getCartByCostumerId(Long customerId){
        Cart cart= cartRepository.findByCustomerId(customerId).orElse(new Cart());
        if(cart==null){
            Customer customer=customerService.getCustomer(customerId);
            cart.setCustomer(customer);
        }
        return cart;
    }

    public Cart saveCart(Cart cart){
        return cartRepository.save(cart);
    }
    public Cart addCartItemToCart(Long customerId, CartItem cartItem){
        Cart cart = getCartByCostumerId(customerId);
        Customer customer=customerService.getCustomer(customerId);


        cartItem.setCart(cart);
        cart.setStoreId(cartItem.getStoreId());
        if(cart==null){
            cart.setCartItems((Set<CartItem>) cartItem);
        }
        else{
            cart.getCartItems().add(cartItem);
        }

        Cart saveCart=saveCart(cart);
        customer.setCart(saveCart);

        return saveCart;

    }

    public Cart getCartByCustomerId(Long customerId) {
        return cartRepository.findByCustomerId(customerId).orElse(new Cart());
    }

    public Cart createCartByCustomerId(Customer customer,Long storeId) {
        Cart newCart=new Cart();
        newCart.setCustomer(customer);
        newCart.setStoreId(storeId);
        return cartRepository.save(newCart);
    }








    /*public Cart saveCart(Long customerId, Long cartItemId) {
        Cart cart=new Cart();
        cart.setCostumerId(customerId);
        cart.setCartItemId(cartItemId);

        return cartRepository.save(cart);
    }

     */


}
