package com.example.ecomweb.repo;

import com.example.ecomweb.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepo extends JpaRepository<Product, Integer> {

    @Query(value = "SELECT * FROM product WHERE category_id = ?1", nativeQuery = true)
    List<Product> getAllProductByID(String id);
}
