package com.example.ecomweb.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column  (name = "category_id", length = 20)
    private int categoryId;

    @Column (name = "category_name", length = 20,nullable = false)
    private String categoryName;

    @Column (name = "image_url", length =250,nullable = false)
    private String imageURL;

    @Column (name= "description", length = 250,nullable = false)
    private String description;

    public Category() {
    }

    public Category(int categoryId, String categoryName, String imageURL, String description) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.imageURL = imageURL;
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", imageURL='" + imageURL + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
