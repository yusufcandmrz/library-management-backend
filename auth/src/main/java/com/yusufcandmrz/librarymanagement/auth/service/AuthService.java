package com.yusufcandmrz.librarymanagement.auth.service;

import com.yusufcandmrz.librarymanagement.auth.dto.request.LoginRequest;
import com.yusufcandmrz.librarymanagement.auth.dto.request.RegisterRequest;
import com.yusufcandmrz.librarymanagement.auth.dto.response.LoginResponse;
import com.yusufcandmrz.librarymanagement.auth.dto.response.RegisterResponse;
import com.yusufcandmrz.librarymanagement.auth.entity.Auth;
import org.springframework.stereotype.Service;

@Service
public interface AuthService {

    public Auth register(RegisterRequest request);

    public Boolean login(LoginRequest request);
}
