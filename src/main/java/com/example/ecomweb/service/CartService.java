package com.example.ecomweb.service;


import com.example.ecomweb.dto.cart.AddToCartDTO;
import com.example.ecomweb.dto.cart.CartDTO;
import com.example.ecomweb.dto.cart.CartItemDTO;
import com.example.ecomweb.entity.Cart;
import com.example.ecomweb.entity.Product;
import com.example.ecomweb.entity.User;
import com.example.ecomweb.exceptions.CustomException;
import com.example.ecomweb.repo.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {
    @Autowired
    ProductService productService;
    @Autowired
    CartRepo cartRepo;
    public void addToCart(AddToCartDTO addToCartDTO, User user) {

        Product product =  productService.findById( addToCartDTO.getProductId());
        Cart cart = new Cart();
        cart.setProduct(product);
        cart.setUser(user);
        cart.setQuantity(addToCartDTO.getQuantity());
        cart.setCreatedDate(new Date());

        cartRepo.save(cart);

    }

    public CartDTO listCartItems(User user) {

        List<Cart> cartList = cartRepo.findAllByUserOrderByCreatedDateDesc(user);
        List<CartItemDTO> cartItem = new ArrayList<>();
        double totalCost = 0;
        for (Cart cart: cartList){
            CartItemDTO cartItemDTO = new CartItemDTO(cart);
            totalCost += cartItemDTO.getQuantity() * cart.getProduct().getPrice();
            cartItem.add(cartItemDTO);
        }
        CartDTO cartDTO = new CartDTO();
        cartDTO.setTotalCost(totalCost);
        cartDTO.setCartItems(cartItem);
        return cartDTO;
    }

    public void deleteCartItem(Integer cartItemId, User user) {

        Optional<Cart> optionalCart = cartRepo.findById(cartItemId);

        if(optionalCart.isEmpty()) {
            throw new CustomException("cart item id is invalid" + cartItemId);
        }
        Cart cart = optionalCart.get();
        if(cart.getUser() != user) {
            throw new CustomException("cart item does not belong to user:" + cartItemId);
        }
        cartRepo.delete(cart);

    }
}
