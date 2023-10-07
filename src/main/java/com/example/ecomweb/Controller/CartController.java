package com.example.ecomweb.Controller;


import com.example.ecomweb.common.ApiResponse;
import com.example.ecomweb.dto.cart.AddToCartDTO;
import com.example.ecomweb.dto.cart.CartDTO;
import com.example.ecomweb.entity.User;
import com.example.ecomweb.service.AuthenticationService;
import com.example.ecomweb.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse>addToCart(@RequestBody AddToCartDTO addToCartDTO,
                                                @RequestParam("token") String token){

        authenticationService.authenticate(token);
        User user = authenticationService.getUser(token);
        cartService.addToCart(addToCartDTO, user);
        return  new ResponseEntity<>(new ApiResponse(true, "Added to cart"), HttpStatus.CREATED);
    }
    @GetMapping("/")
    public ResponseEntity<CartDTO> getCartItems(@RequestParam("token") String token) {

        authenticationService.authenticate(token);


        User user = authenticationService.getUser(token);
        CartDTO cartDTO = cartService.listCartItems(user);
        return new ResponseEntity<>(cartDTO,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{cartItemId")
    public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable("cartItem") Integer cartItemId,
                                                      @RequestParam ("token") String token){

        authenticationService.authenticate(token);

        User user = authenticationService.getUser(token);

        cartService.deleteCartItem(cartItemId, user);
        return  new ResponseEntity<>(new ApiResponse(true,"Item has been removed"),HttpStatus.OK);

    }


}
