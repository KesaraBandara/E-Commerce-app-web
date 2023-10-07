package com.example.ecomweb.service;


import com.example.ecomweb.entity.Category;
import com.example.ecomweb.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    public void createCategory(Category category) {
        categoryRepo.save(category);
    }
    public List <Category> listCategory() {
        return categoryRepo.findAll();
    }

    public void editCategory(int categoryId, Category updatrCategory) {
        Category category = categoryRepo.getById(categoryId);
        category.setCategoryName(updatrCategory.getCategoryName());
        category.setDescription(updatrCategory.getDescription());
        category.setImageURL(updatrCategory.getImageURL());
        categoryRepo.save(category);
    }

    public boolean findById(int categoryId) {
        return categoryRepo.findById(categoryId).isPresent();
    }
}
