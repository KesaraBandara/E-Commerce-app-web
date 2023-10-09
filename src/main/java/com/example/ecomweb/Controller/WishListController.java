package com.example.ecomweb.Controller;


import com.example.ecomweb.common.ApiResponse;
import com.example.ecomweb.dto.ProductDTO;
import com.example.ecomweb.entity.Product;
import com.example.ecomweb.entity.User;
import com.example.ecomweb.entity.WishList;
import com.example.ecomweb.service.AuthenticationService;
import com.example.ecomweb.service.WishListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/wishlist")
public class WishListController {
    @Autowired
    WishListService wishListService;
    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addTowWishList(@RequestBody Product product, @RequestParam ("token") String token){

        authenticationService.authenticate(token);

        User user = authenticationService.getUser(token);
        WishList wishList = new WishList(user, product);
        wishListService.createWishList(wishList);

        ApiResponse apiResponse = new ApiResponse(true,"Added to wish list");
        return new ResponseEntity<>( apiResponse, HttpStatus.CREATED);
    }
    @GetMapping("/{token}")
    public ResponseEntity<List<ProductDTO>> getWishList(@PathVariable("token") String token) {

        authenticationService.authenticate(token);

        User user = authenticationService.getUser(token);
        List<ProductDTO> productDTOS = wishListService.getWishList(user);
        return new ResponseEntity<>( productDTOS, HttpStatus.OK);
    }

}
