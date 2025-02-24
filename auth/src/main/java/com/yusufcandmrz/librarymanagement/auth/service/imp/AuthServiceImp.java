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
        if (!request.getPassword().equals(request.getPasswordAgain())) {
            throw new RuntimeException("Passwords do not match");
        } else if (authRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        } else {
            return authRepository.save(modelMapper.map(request, Auth.class));
        }
    }

    @Override
    public Boolean login(LoginRequest request) {
        return authRepository.existsByEmailAndPassword(request.getEmail(), request.getPassword());
    }
}
