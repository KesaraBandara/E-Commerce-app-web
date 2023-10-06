package com.example.ecomweb.repo;


import com.example.ecomweb.entity.AuthenticationToken;
import com.example.ecomweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepo  extends JpaRepository<AuthenticationToken, Integer> {
    AuthenticationToken findByUser(User user);

    AuthenticationToken findByToken(String token);
}
