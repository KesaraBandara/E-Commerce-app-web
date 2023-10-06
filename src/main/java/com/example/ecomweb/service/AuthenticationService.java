package com.example.ecomweb.service;


import com.example.ecomweb.entity.AuthenticationToken;
import com.example.ecomweb.entity.User;
import com.example.ecomweb.exceptions.AuthenticationFailException;
import com.example.ecomweb.repo.TokenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthenticationService {
    @Autowired
    TokenRepo tokenRepo;
    public void saveConfirmationToken(AuthenticationToken authenticationToken) {
        tokenRepo.save(authenticationToken);
    }

    public AuthenticationToken getToken(User user) {
        return tokenRepo.findByUser(user);
    }
    public User getUser(String token){
        final AuthenticationToken authenticationToken = tokenRepo.findByToken(token);
        if(Objects.isNull(authenticationToken)){
            return null;
        }
        return authenticationToken.getUser();
    }
    public void authenticate(String token){
        if(Objects.isNull(token)){
            throw new AuthenticationFailException("token not present");
        }
        if(Objects.isNull(getUser(token))){
            throw new AuthenticationFailException("token not present");
        }
    }
}
