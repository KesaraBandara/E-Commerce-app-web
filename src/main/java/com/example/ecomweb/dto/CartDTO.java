package com.example.ecomweb.dto;

public class CartDTO {

    private int id;
    private int product_id;
    private String imageURL;
    private int user_id;
    private String crete_date;
    private int quantity;

    public CartDTO() {
    }

    public CartDTO(int id, int product_id, String imageURL, int user_id, String crete_date, int quantity) {
        this.id = id;
        this.product_id = product_id;
        this.imageURL = imageURL;
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

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
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
        return "CartDTO{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", imageURL='" + imageURL + '\'' +
                ", user_id=" + user_id +
                ", crete_date='" + crete_date + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
