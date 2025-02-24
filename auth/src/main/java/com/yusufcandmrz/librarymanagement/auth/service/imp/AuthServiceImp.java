package com.yusufcandmrz.librarymanagement.auth.service.imp;

import com.yusufcandmrz.librarymanagement.auth.dto.request.LoginRequest;
import com.yusufcandmrz.librarymanagement.auth.dto.request.RegisterRequest;
import com.yusufcandmrz.librarymanagement.auth.dto.response.RegisterResponse;
import com.yusufcandmrz.librarymanagement.auth.entity.Auth;
import com.yusufcandmrz.librarymanagement.auth.repository.AuthRepository;
import com.yusufcandmrz.librarymanagement.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class AuthServiceImp implements AuthService {

    AuthRepository authRepository;
    ModelMapper modelMapper;

    @Autowired
    public AuthServiceImp(AuthRepository authRepository, ModelMapper modelMapper) {
        this.authRepository = authRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Auth register(RegisterRequest request) {
        if(!request.getPassword().equals(request.getPasswordAgain())) {
            // Handle this code line
        }
        // Check that e-mail and password are valid
        // Control that e-mail is used before. Need to Account service
        // Create Auth
        Auth auth = modelMapper.map(request, Auth.class);
        return authRepository.save(auth);
    }

    @Override
    public boolean login(LoginRequest request) {
        return false;
    }
}
