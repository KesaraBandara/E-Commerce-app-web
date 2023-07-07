package com.example.ecomweb.service;

import com.example.ecomweb.dto.ProductDTO;
import com.example.ecomweb.entity.Product;
import com.example.ecomweb.repo.ProductRepo;
import com.example.ecomweb.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveProduct(ProductDTO productDTO) {

            if (productRepo.existsById(productDTO.getProductId())) {
                return VarList.RSP_DUPLICATED;
            } else {
                productRepo.save(modelMapper.map(productDTO, Product.class));
                return VarList.RSP_SUCCESS;
            }
        }

    }

