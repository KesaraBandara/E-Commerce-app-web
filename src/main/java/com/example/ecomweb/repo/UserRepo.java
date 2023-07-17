package com.example.ecomweb.repo;

//import org.apache.catalina.User;
import com.example.ecomweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface UserRepo extends JpaRepository<User,Integer> {

    }
