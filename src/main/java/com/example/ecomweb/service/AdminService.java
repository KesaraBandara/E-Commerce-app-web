package com.example.ecomweb.service;
import com.example.ecomweb.dto.AdminDTO;
import com.example.ecomweb.entity.Admin;
import com.example.ecomweb.repo.AdminRepo;
import com.example.ecomweb.util.VarList;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class AdminService {

    @Autowired
    private AdminRepo adminRepo;

    @Autowired
    private ModelMapper modelMapper;

    public String checkAdmin(AdminDTO adminDTO) {
        int userID = adminDTO.getAdminID();
        String username = adminDTO.getUserName();
        String password = adminDTO.getPassword();

        Admin admin = adminRepo.findByAdminIDAndUserNameAndPasswordEquals(userID, username, password);

        if (admin != null) {
            return VarList.RSP_SUCCESS;
        } else {
            return VarList.RSP_DUPLICATED;
        }
    }
}

