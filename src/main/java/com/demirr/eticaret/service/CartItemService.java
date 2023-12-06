package com.demirr.eticaret.service;

import com.demirr.eticaret.dto.request.CartItemRequest;
import com.demirr.eticaret.dto.response.CartItemResponse;
import com.demirr.eticaret.entities.Cart;
import com.demirr.eticaret.entities.CartItem;
import com.demirr.eticaret.entities.Customer;
import com.demirr.eticaret.entities.Product;
import com.demirr.eticaret.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service

public class CartItemService {
    private final CartItemRepository cartItemRepository;
    private final ProductService productService;
    private final CartService cartService;
    private final ShoppingCartService shoppingCartService;
    private final CustomerService customerService;



    public CartItemService(CartItemRepository cartItemRepository, ProductService productService, CartService cartService, ShoppingCartService shoppingCartService, CustomerService customerService) {
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
            cartItem.setStoreId(product.getStoreId());
            cartItem.setCart(customer.getCart());
            cartItemRepository.save(cartItem);
        } else {

            cartItem = new CartItem();
            cartItem.setAdet(request.getAdet());
            cartItem.setCustomerId(request.getCustomerId());
            cartItem.setProduct(product);
            cartItem.setCart(customer.getCart());
            cartItem.setToplamFiyat(toplamFiyat);
            cartItem.setStoreId(product.getStoreId());
            cartItemRepository.save(cartItem);
        }

        shoppingCartService.addProductToCart(cartItem);

        return new CartItemResponse(cartItem.getAdet(), product.getId(), cartItem.getToplamFiyat(), Optional.ofNullable(product.getName()));

    }

  /*  public Cart findCartByCustomerId(Long customerId){
        Cart cart = cartService.getCartByCostumerId(customerId);
        if(cart.getId()==null){
            cart.setCostumerId(customerId);
        }

        return cartService.saveCart(cart);
    }*/



    /*public Cart addCartItemToCart(Long customerId, Long cartItemId){
        Cart cart = cartService.getCartByCostumerId(customerId);
        Customer customer=customerService.getCustomer(customerId);

        //Cart cart=customer.getCart();

        CartItem cartItem=getOneCartItemById(cartItemId);
        cartItem.setCart(cart);
        cart.setStoreId(cartItem.getStoreId());
        if(cart==null){
            cart.setCartItems((Set<CartItem>) cartItem);
        }
        else{
            cart.getCartItems().add(cartItem);
        }

       Cart saveCart= cartService.saveCart(cart);
       customer.setCart(saveCart);

        return saveCart;

    }*/

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

    public void deleteCartItemByProductId(Long productId){
        cartItemRepository.deleteByProductId(productId);
    }

    public void deleteCartItem(CartItem cartItem){
        cartItemRepository.delete(cartItem);
    }
}
