package com.example.ecomweb.dto.cart;


import com.example.ecomweb.entity.Cart;
import com.example.ecomweb.entity.Product;
import io.swagger.models.auth.In;

public class CartItemDTO {
    private  Integer id;
    private Integer quantity;
    private Product product;

    public CartItemDTO() {
    }

    public CartItemDTO(Integer id, Integer quantity, Product product) {
        this.id = id;
        this.quantity = quantity;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    public CartItemDTO(Cart cart){
        this.id = cart.getId();
        this.quantity = cart.getQuantity();
        this.setProduct(cart.getProduct());
    }

    @Override
    public String toString() {
        return "CartItemDTO{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
