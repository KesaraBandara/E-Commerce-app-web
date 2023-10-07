package com.example.ecomweb.Controller;

import com.ec.ec.service.ProductService;
import com.example.ecomweb.common.ApiResponse;
import com.example.ecomweb.dto.ProductDTO;
import com.example.ecomweb.entity.Category;
import com.example.ecomweb.repo.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryRepo categoryRepo;
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDTO productDTO) {
        Optional<Category> optionalCategory = categoryRepo.findById((productDTO.getCategoryId()));
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(false, "Product does not exist"), HttpStatus.BAD_REQUEST);
        }
        productService.createProduct(productDTO, optionalCategory.get());
        return new ResponseEntity<>(new ApiResponse(true,"Product has been added"), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<List<ProductDTO>>getAllProducts() {
        final List<ProductDTO> products = productService.getAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PutMapping("/update/{productId}")
    public ResponseEntity<ApiResponse> updateProduct(@PathVariable("productId") int productId,@RequestBody ProductDTO productDTO) throws Exception {
        Optional<Category> optionalCategory = categoryRepo.findById((productDTO.getCategoryId()));
        if (!optionalCategory.isPresent()) {
            return new ResponseEntity<>(new ApiResponse(false, "Product does not exist"), HttpStatus.BAD_REQUEST);
        }
        productService.updateProduct(productDTO,productId);
        return new ResponseEntity<>(new ApiResponse(true,"Product has been updated"), HttpStatus.OK);
    }
}
