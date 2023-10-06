//package com.example.ecomweb.Controller;
//
//
//import com.example.ecomweb.dto.ResponseDTO;
//import com.example.ecomweb.dto.UserDTO;
//import com.example.ecomweb.dto.SearchUserDTO;
//import com.example.ecomweb.service.UserService;
//import com.example.ecomweb.util.VarList;
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//
//
//@RestController
//@RequestMapping("api/v1/user")
//public class UserController {
//
//    @Autowired
//    public UserService userService;
//
//    @Autowired
//    public ResponseDTO responseDTO;
//
//
//
//
//
//    @PostMapping(value = "/saveUser")
//    public ResponseEntity saveUser(@RequestBody UserDTO userDTO){
//
//        try{
//
//            String res = userService.saveUser(userDTO);
//            if (res.equals("00")){
//
////                // User signup successful, create a session for the user
////                HttpSession session = request.getSession();
////                session.setAttribute("userId", userDTO.getUserId());
////                session.setAttribute("userName", userDTO.getfName());
////
////                // Set a cookie to remember the user's login
////                Cookie loginCookie = new Cookie("loggedInUser", userDTO.getfName());
////                loginCookie.setMaxAge(60 * 60 * 24 * 30); // Cookie will expire after 30 days
////                response.addCookie(loginCookie);
//
//                responseDTO.setCode(VarList.RSP_SUCCESS);
//                responseDTO.setMessage("Success");
//                responseDTO.setContent(userDTO);
//                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
//            }
//            else if (res.equals("06")){
//                responseDTO.setCode(VarList.RSP_DUPLICATED);
//                responseDTO.setMessage("Already added");
//                responseDTO.setContent(userDTO);
//                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
//            }
//            else {
//                responseDTO.setCode(VarList.RSP_FAIL);
//                responseDTO.setMessage("Error");
//                responseDTO.setContent(null);
//                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
//            }
//        }
//
//        catch (Exception exception){
//            responseDTO.setCode(VarList.RSP_ERROR);
//            responseDTO.setMessage(exception.getMessage());
//            responseDTO.setContent(null);
//            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }
//
////    @GetMapping("/searchUserById/{id}/{username}/{password}")
////    public ResponseEntity searchUser(@PathVariable int id ,@PathVariable String username ,@PathVariable String password){
////
////
////        try{
////
////            String res = userService.searchUserById(id,username,password);
////            if (res.equals("00")){
////                responseDTO.setCode(VarList.RSP_SUCCESS);
////                responseDTO.setMessage("Success");
////                responseDTO.setContent(null);
////                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
////            }
////            else if (res.equals("01")){
////                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
////                responseDTO.setMessage("Not Found");
////                responseDTO.setContent(null);
////                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
////            }
////            else {
////                responseDTO.setCode(VarList.RSP_FAIL);
////                responseDTO.setMessage("Error");
////                responseDTO.setContent(null);
////                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
////            }
////        }
////
////        catch (Exception exception){
////            responseDTO.setCode(VarList.RSP_ERROR);
////            responseDTO.setMessage(exception.getMessage());
////            responseDTO.setContent(null);
////            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
////        }
////
////
////    }
//@PostMapping("/searchUser")
//public ResponseEntity searchUser(@RequestBody SearchUserDTO searchUserDTO) {
//
//
//    try {
//        String res = userService.searchUserById(searchUserDTO);
//
//        if (res.equals("00")) {
//
//            // User signin successful, create a session for the user
////            HttpSession session = request.getSession();
////            session.setAttribute("userId", searchUserDTO.getUserId());
////            session.setAttribute("userName", searchUserDTO.getfName());
//
//            responseDTO.setCode(VarList.RSP_SUCCESS);
//            responseDTO.setMessage("Success");
//            responseDTO.setContent(null);
//            return new ResponseEntity(responseDTO, HttpStatus.OK);
//        } else if (res.equals("01")) {
//            responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
//            responseDTO.setMessage("Not Found");
//            responseDTO.setContent(null);
//            return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
//        } else {
//            responseDTO.setCode(VarList.RSP_FAIL);
//            responseDTO.setMessage("Error");
//            responseDTO.setContent(null);
//            return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
//        }
//    } catch (Exception exception) {
//        responseDTO.setCode(VarList.RSP_ERROR);
//        responseDTO.setMessage(exception.getMessage());
//        responseDTO.setContent(null);
//        return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//}
//
//
//}

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
