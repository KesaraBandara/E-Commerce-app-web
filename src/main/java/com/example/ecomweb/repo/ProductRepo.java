package com.example.ecomweb.repo;

import com.example.ecomweb.entity.Category;
import com.example.ecomweb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepo extends JpaRepository<Product,Integer> {
}
