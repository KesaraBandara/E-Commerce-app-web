package com.example.ecomweb.service;


import com.example.ecomweb.dto.ProductDTO;
import com.example.ecomweb.entity.Category;
import com.example.ecomweb.entity.Product;
import com.example.ecomweb.exceptions.ProductNoExistsException;
import com.example.ecomweb.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepo productRepo;

    public void createProduct(ProductDTO productDTO, Category category) {
        Product product = new Product();
        product.setDescription(productDTO.getDescription());
        product.setImageURL(productDTO.getImageURL());
        product.setName(product.getName());
        product.setCategory(category );
        product.setPrice(productDTO.getPrice());
        productRepo.save(product);
    }
    public ProductDTO getProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();
        productDTO.setDescription(product.getDescription());
        productDTO.setImageURL(product.getImageURL());
        productDTO.setName(product.getName());
        productDTO.setCategoryId( product.getCategory().getId());
        productDTO.setPrice(productDTO.getPrice());
        productDTO.setId(product.getId());
        return productDTO;

    }

    public List<ProductDTO>getAllProducts() {
        List<Product> allProducts = productRepo.findAll();

        List<ProductDTO> productDTOS = new ArrayList<>();
        for (Product product: allProducts){
            productDTOS.add(getProductDTO(product));
        }
        return productDTOS;
    }

    public void updateProduct(ProductDTO productDTO, Integer productId) throws Exception {
        Optional<Product> optionalProduct = productRepo.findById(productId);
        if(!optionalProduct.isPresent()) {
            throw new Exception("Product not found");
        }

        Product product = optionalProduct.get();
        product.setDescription(productDTO.getDescription());
        product.setImageURL(productDTO.getImageURL());
        product.setName(product.getName());
        product.setPrice(productDTO.getPrice());
        productRepo.save(product);
    }

    public Product findById(Integer productId)throws ProductNoExistsException {
        Optional<Product> optionalProduct =  productRepo.findById(productId);
        if(optionalProduct.isEmpty()) {
            throw  new ProductNoExistsException("product is invalid"  + productId);
        }
        return optionalProduct.get();
    }
}
