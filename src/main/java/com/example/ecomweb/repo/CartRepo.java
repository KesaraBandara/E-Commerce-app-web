package com.example.ecomweb.repo;

import com.example.ecomweb.entity.Cart;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CartRepo extends JpaRepository<Cart,Integer> {

    @Query(value = "SELECT * FROM cart WHERE user_id = ?1", nativeQuery = true)
    List<Cart> getProductByID(String id);

//    @Query(value = "DELETE FROM cart WHERE user_id = ?1", nativeQuery = true)
//    void deleteByUserId(String user_id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM cart WHERE user_id = ?1", nativeQuery = true)
    void deleteByUser_id(String user_id);

}
