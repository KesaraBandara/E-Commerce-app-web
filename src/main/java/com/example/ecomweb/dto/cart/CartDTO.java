package com.example.ecomweb.dto.cart;

import org.apache.catalina.LifecycleState;

import java.util.List;

public class CartDTO {
    private List<CartItemDTO> cartItems;
    private  double totalCost;

    public CartDTO() {
    }

    public CartDTO(List<CartItemDTO> cartItems, double totalCost) {
        this.cartItems = cartItems;
        this.totalCost = totalCost;
    }

    public List<CartItemDTO> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDTO> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    @Override
    public String toString() {
        return "CartDTO{" +
                "cartItems=" + cartItems +
                ", totalCost=" + totalCost +
                '}';
    }
}
