package com.example.ecomweb.repo;

import com.example.ecomweb.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepo extends JpaRepository<Category,Integer> {
}
