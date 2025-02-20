package com.yusufcandmrz.librarymanagement.auth.service;

import com.yusufcandmrz.librarymanagement.auth.dto.request.LoginRequest;
import com.yusufcandmrz.librarymanagement.auth.dto.request.RegisterRequest;
import com.yusufcandmrz.librarymanagement.auth.dto.response.LoginResponse;
import com.yusufcandmrz.librarymanagement.auth.dto.response.RegisterResponse;

public interface AuthService {

    public RegisterResponse register(RegisterRequest request);

    public boolean login(LoginRequest request);
}
