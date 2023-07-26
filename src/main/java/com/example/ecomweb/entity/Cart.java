package com.example.ecomweb.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name ="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column  (name = "id", length = 20)
    private int id;
    @Column (name = "image_url", length =700,nullable = false)
    private String imageURL;

    @Column (name = "product_id", length = 20,nullable = false)
    private int product_id;
    @Column (name = "user_id", length = 20,nullable = false)
    private int user_id;
    @Column (name = "crete_date", length = 20,nullable = false)
    private String crete_date;
    @Column (name = "quantity", length = 20,nullable = false)
    private int quantity;

    public Cart() {
    }

    public Cart(int id, String imageURL, int product_id, int user_id, String crete_date, int quantity) {
        this.id = id;
        this.imageURL = imageURL;
        this.product_id = product_id;
        this.user_id = user_id;
        this.crete_date = crete_date;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCrete_date() {
        return crete_date;
    }

    public void setCrete_date(String crete_date) {
        this.crete_date = crete_date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", imageURL='" + imageURL + '\'' +
                ", product_id=" + product_id +
                ", user_id=" + user_id +
                ", crete_date='" + crete_date + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
