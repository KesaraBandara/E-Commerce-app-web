package com.example.ecomweb.service;


import com.example.ecomweb.dto.ResponseDTO;
import com.example.ecomweb.dto.user.SignInDTO;
import com.example.ecomweb.dto.user.SignInResponseDTO;
import com.example.ecomweb.dto.user.SignUpDTO;
import com.example.ecomweb.entity.AuthenticationToken;
import com.example.ecomweb.entity.User;
import com.example.ecomweb.exceptions.AuthenticationFailException;
import com.example.ecomweb.exceptions.CustomException;
import com.example.ecomweb.repo.UserRepo;
import org.hibernate.type.DateType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Objects;

@Service
public class UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    AuthenticationService authenticationService;

    public ResponseDTO signUp(SignUpDTO signUpDTO) throws NoSuchAlgorithmException {
        if(Objects.nonNull(userRepo.findByEmail(signUpDTO.getEmail()))){
            throw new CustomException("user already present");
        }
        String encryptedPassword = hashPassword(signUpDTO.getPassword());
        try{
            encryptedPassword = hashPassword(signUpDTO.getPassword());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();

        }
        User user = new User(signUpDTO.getFirstName(), signUpDTO.getLastName(), signUpDTO.getEmail(),encryptedPassword);
        userRepo.save(user);

        final AuthenticationToken authenticationToken = new AuthenticationToken(user);
        authenticationService.saveConfirmationToken(authenticationToken);


        ResponseDTO responseDTO = new ResponseDTO("Success", "user created successfully");
        return  responseDTO;
    }

    private String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String hash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return hash;
    }

    public SignInResponseDTO signIn(SignInDTO signInDTO) {
        User user = (User) userRepo.findByEmail(signInDTO.getEmail());
        if(Objects.isNull(user)) {
            throw new AuthenticationFailException("user is not valid");
        }
        try {
            if(!user.getPassword().equals(hashPassword(signInDTO.getPassword()))) {
                throw new AuthenticationFailException("wrong password");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        AuthenticationToken token = authenticationService.getToken(user);

        if(Objects.isNull(token)) {
            throw new CustomException("token is not present");
        }
        return new SignInResponseDTO("user", token.getToken());
    }
}
