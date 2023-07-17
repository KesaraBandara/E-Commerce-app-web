package com.example.ecomweb.Controller;

import com.example.ecomweb.dto.CategoryDTO;
import com.example.ecomweb.dto.ProductDTO;
import com.example.ecomweb.dto.ResponseDTO;
import com.example.ecomweb.entity.Product;
import com.example.ecomweb.service.CategoryService;
import com.example.ecomweb.service.ProductService;
import com.example.ecomweb.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    public ProductService productService;

    @Autowired
    private ResponseDTO responseDTO;


    @PostMapping(value = "/saveProduct")
    public ResponseEntity saveProduct(@RequestBody ProductDTO productDTO){

        try{

            String res = productService.saveProduct(productDTO);
            if (res.equals("00")){
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(productDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            }
            else if (res.equals("06")){
                responseDTO.setCode(VarList.RSP_DUPLICATED);
                responseDTO.setMessage("Already added");
                responseDTO.setContent(productDTO);
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

//    @GetMapping(
//            path ={"/getAllProductsByID"},
//            params ={"id"})
//
//    public ResponseEntity getAllProductsByID(RequestParam(@RequestParam (value = "id") String categoryID) {
//        ResponseEntity result;
//        try {
//
//            List<ProductDTO> productDTOList = productService.getAllProductsByID(categoryID);
//            responseDTO.setCode(VarList.RSP_SUCCESS);
//            responseDTO.setMessage("Success");
//            responseDTO.setContent(productDTOList);
//            result = new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
//
//
//        } catch (Exception exception) {
//
//            responseDTO.setCode(VarList.RSP_ERROR);
//            responseDTO.setMessage(exception.getMessage());
//            responseDTO.setContent(null);
//            result = new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
//
//        }
//        return result;
//    }
//@GetMapping("/getAllProductsByID/{id}")
//public List<Product> getAllProductsByID(@PathVariable String CategoryID) {
//    return productService.getAllProductsByID(CategoryID);
//}
    @GetMapping("/getAllProductsByID/{id}")
    public ResponseEntity getAllProductsByID(@PathVariable String id){

        try {
            List<ProductDTO> productDTO = productService.getAllProductsByID(id);
            if (productDTO !=null) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                responseDTO.setContent(productDTO);
                System.out.println(responseDTO);
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
            } else {
                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No Employee Available For this empID");
                responseDTO.setContent(null);
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception exception) {
            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(exception.getMessage());
            responseDTO.setContent(exception);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        }



}