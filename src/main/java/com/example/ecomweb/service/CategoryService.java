package com.example.ecomweb.service;

import com.example.ecomweb.dto.CategoryDTO;
import com.example.ecomweb.entity.Category;
import com.example.ecomweb.repo.CategoryRepo;
import com.example.ecomweb.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String saveCategory(CategoryDTO categoryDTO) {

        if (categoryRepo.existsById(categoryDTO.getCategoryId())) {

            return VarList.RSP_DUPLICATED;
        } else {
            categoryRepo.save(modelMapper.map(categoryDTO, Category.class));

            return VarList.RSP_SUCCESS;
        }
     }

    public List<CategoryDTO> getAllCategories() {

            List<Category> categoryList = categoryRepo.findAll();
            return modelMapper.map(categoryList, new TypeToken<ArrayList<CategoryDTO>>() {
            }.getType());


    }
}
