package com.example.ecomweb.dto;

public class ProductDTO {

    private int productId;
    private String productName;
    private double price;
    private String imageURL;
    private String description;
    private String addDate;
    private String categoryID;

    public ProductDTO() {
    }

    public ProductDTO(int productId, String productName,double price, String imageURL, String description, String addDate, String categoryID) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
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
    public void setPrice(Double price){
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
        return "ProductDTO{" +
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
