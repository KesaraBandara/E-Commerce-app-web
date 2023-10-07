

package com.example.ecomweb.Controller;


import com.example.ecomweb.dto.ResponseDTO;
import com.example.ecomweb.dto.user.SignInDTO;
import com.example.ecomweb.dto.user.SignInResponseDTO;
import com.example.ecomweb.dto.user.SignUpDTO;
import com.example.ecomweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/signUp")
    public ResponseDTO signUp(@RequestBody SignUpDTO signUpDTO) throws NoSuchAlgorithmException {
        return userService.signUp(signUpDTO);
    }

    @PostMapping("/signIn")
    public SignInResponseDTO signIn(@RequestBody SignInDTO signInDTO){
        return userService.signIn(signInDTO);
    }


}
