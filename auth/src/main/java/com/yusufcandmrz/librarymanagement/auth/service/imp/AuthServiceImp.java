package com.yusufcandmrz.librarymanagement.auth.service.imp;

import com.yusufcandmrz.librarymanagement.auth.dto.request.LoginRequest;
import com.yusufcandmrz.librarymanagement.auth.dto.request.RegisterRequest;
import com.yusufcandmrz.librarymanagement.auth.dto.response.LoginResponse;
import com.yusufcandmrz.librarymanagement.auth.dto.response.RegisterResponse;
import com.yusufcandmrz.librarymanagement.auth.service.AuthService;

public class AuthServiceImp implements AuthService {

    @Override
    public RegisterResponse register(RegisterRequest request) {
        return null;
    }

    @Override
    public boolean login(LoginRequest request) {
        return false;
    }
}
