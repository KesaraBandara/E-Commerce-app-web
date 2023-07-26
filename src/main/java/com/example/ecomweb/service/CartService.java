package com.example.ecomweb.service;

import com.example.ecomweb.dto.CartDTO;
import com.example.ecomweb.dto.ProductDTO;
import com.example.ecomweb.entity.Cart;
import com.example.ecomweb.entity.Product;
import com.example.ecomweb.repo.CartRepo;
import com.example.ecomweb.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class CartService {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ModelMapper modelMapper;
    public String addCart(CartDTO cartDTO) {

        if (cartRepo.existsById(cartDTO.getId())) {
            return VarList.RSP_DUPLICATED;
        } else {
            cartRepo.save(modelMapper.map(cartDTO,Cart.class));
            return VarList.RSP_SUCCESS;
        }    }

    public List<CartDTO> getAllProductsToCartByID(String id) {

        List<Cart> cartProductList = cartRepo.getProductByID(id);
        return modelMapper.map(cartProductList, new TypeToken<List<CartDTO>>() {}.getType());

    }

    public String deleteProductInCart(String user_id,String id) {
        if (cartRepo.existsById(Integer.valueOf(id))) {
            cartRepo.deleteByUser_id(user_id);
            return VarList.RSP_SUCCESS;
        } else {
            return VarList.RSP_NO_DATA_FOUND;
        }
}

}
