package com.example.ecomweb.repo;


import com.example.ecomweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
    Object findByEmail(String email);
}
