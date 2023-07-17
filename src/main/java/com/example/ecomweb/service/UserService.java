package com.example.ecomweb.service;

import com.example.ecomweb.dto.UserDTO;
import com.example.ecomweb.entity.User;
import com.example.ecomweb.repo.UserRepo;
import com.example.ecomweb.util.VarList;
import jakarta.transaction.Transactional;
//
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;


    public String saveUser(UserDTO userDTO) {

        if (userRepo.existsById(userDTO.getUserId())) {

            return VarList.RSP_DUPLICATED;
        } else {
            userRepo.save(modelMapper.map(userDTO, User.class));

            return VarList.RSP_SUCCESS;
        }
    }

    public String searchUserById(int id, String userName, String password) {

        if (userRepo.existsById(id)) {

            User user = userRepo.findById(id).orElse(null);

            if (user != null) {
                String storedUserName = user.getfName();
                String storedPassword = user.getPassword();

                if (storedUserName.equalsIgnoreCase(userName) && storedPassword.equalsIgnoreCase(password)) {
                    return VarList.RSP_SUCCESS;
                } else {
                    return VarList.RSP_NO_DATA_FOUND;
                }
            } else {
                return VarList.RSP_ERROR;
            }
        } else {
            return VarList.RSP_ERROR;
        }
    }
}

