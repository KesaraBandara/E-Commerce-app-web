package com.example.ecomweb.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name ="product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column  (name = "product_id", length = 20)
    private int productId;

    @Column (name = "product_name", length = 20)
    private String productName;
    @Column(name="price", length =10)
    private double price;
    @Column(name = "product_image", length = 200)
    private String imageURL;

    @Column(name = "description", length =100)
    private String description;

    @Column(name ="date", length =10)
    private String addDate;

    @Column(name ="category_id", length =20)
    private String categoryID;

    public Product() {
    }

    public Product(int productId, String productName,double price, String imageURL, String description, String addDate, String categoryID) {
        this.productId = productId;
        this.productName = productName;
        this.price= price;
        this.imageURL = imageURL;
        this.description = description;
        this.addDate = addDate;
        this.categoryID = categoryID;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", imageURL='" + imageURL + '\'' +
                ", description='" + description + '\'' +
                ", addDate='" + addDate + '\'' +
                ", categoryID='" + categoryID + '\'' +
                '}';
    }
}
