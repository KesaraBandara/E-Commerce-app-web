package com.example.ecomweb.service;


import com.example.ecomweb.dto.ProductDTO;
import com.example.ecomweb.entity.User;
import com.example.ecomweb.entity.WishList;
import com.example.ecomweb.repo.WishListRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishListService {
    @Autowired
    ProductService productService;

    @Autowired
    WishListRepo wishListRepo;

    public void createWishList(WishList wishList) {
        wishListRepo.save(wishList);
    }


    public List<ProductDTO> getWishList(User user) {
        final List<WishList> wishLists =  wishListRepo.findAllByUserOrderByCreatedDateDesc(user);
        List<ProductDTO> productDTOS = new ArrayList<>();
        for (WishList wishList : wishLists) {
            productDTOS.add(productService.getProductDTO(wishList.getProduct()));
        }
        return productDTOS;
    }
}
