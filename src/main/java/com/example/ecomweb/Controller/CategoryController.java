package com.example.ecomweb.Controller;


import com.example.ecomweb.dto.CategoryDTO;
import com.example.ecomweb.dto.ResponseDTO;
import com.example.ecomweb.service.CategoryService;
import com.example.ecomweb.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/category")
public class CategoryController {

    @Autowired
    public CategoryService categoryService;

    @Autowired
    private ResponseDTO responseDTO;


    @PostMapping(value = "/saveCategory")
    public ResponseEntity saveCategory(@RequestBody CategoryDTO categoryDTO){

        try{

            String res = categoryService.saveCategory(categoryDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(categoryDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }
            else if (res.equals("06")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Already added");
                responseDTO.setContent(categoryDTO);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
            else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        }

        catch (Exception exception){
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(exception.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAllCategories")
    public ResponseEntity getAllCategories() {

        try {

            List<CategoryDTO> categoryDTOList = categoryService.getAllCategories();
            responseDTO.setCode(VarList.RSP_SUCCESS);
            responseDTO.setMessage("Success");
            responseDTO.setContent(categoryDTOList);
            return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);


        } catch (Exception exception) {

            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(exception.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

}
