package com.example.ecomweb.Controller;

import com.example.ecomweb.dto.AdminDTO;
import com.example.ecomweb.dto.CategoryDTO;
import com.example.ecomweb.dto.ResponseDTO;
import com.example.ecomweb.service.AdminService;
import com.example.ecomweb.service.CategoryService;
import com.example.ecomweb.util.VarList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/admin")
public class AdminLoginController {

    @Autowired
    public AdminService adminService;

    @Autowired
    private ResponseDTO responseDTO;


    @PostMapping(value = "/checkAdmin")
    public ResponseEntity checkAdmin(@RequestBody AdminDTO adminDTO) {
        try {

            String res = adminService.checkAdmin(adminDTO);
            if (res.equals("00")) {
                responseDTO.setCode(VarList.RSP_SUCCESS);
                responseDTO.setMessage("Success");
                return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);

            } else if (res.equals("06")) {

                responseDTO.setCode(VarList.RSP_NO_DATA_FOUND);
                responseDTO.setMessage("No data found");
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            } else {
                responseDTO.setCode(VarList.RSP_FAIL);
                responseDTO.setMessage("Error");
                return new ResponseEntity(responseDTO, HttpStatus.BAD_REQUEST);
            }
        } catch (Exception exception) {

            responseDTO.setCode(VarList.RSP_ERROR);
            responseDTO.setMessage(exception.getMessage());
            responseDTO.setContent(null);
            return new ResponseEntity(responseDTO, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
