package com.example.ecomweb.Controller;


import com.example.ecomweb.common.ApiResponse;
import com.example.ecomweb.entity.Category;
import com.example.ecomweb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;
    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>(new ApiResponse(true,"Category created successfully"),HttpStatus.CREATED);
    }
    @GetMapping("/list")
    public List<Category> listCategory() {

        return categoryService.listCategory();
    }
    @PutMapping("/Update/categoryId")
    public ResponseEntity<ApiResponse> updateCategory(@PathVariable("categoryId") int categoryId, @RequestBody Category category){
        if(!categoryService.findById(categoryId)){
            return new ResponseEntity<>(new ApiResponse(true,"Category has been update"),HttpStatus.NOT_FOUND);

        }
        categoryService.editCategory(categoryId, category);
        return new ResponseEntity<>(new ApiResponse(true,"Category has been update"),HttpStatus.OK);

    }
}
