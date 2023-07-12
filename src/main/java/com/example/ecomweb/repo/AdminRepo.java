package com.example.ecomweb.repo;

import com.example.ecomweb.entity.Admin;
import com.example.ecomweb.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;


    public interface AdminRepo extends JpaRepository<Admin,Integer>{

        Admin findByAdminIDAndUserNameAndPasswordEquals(int userID, String username, String password);
    }
