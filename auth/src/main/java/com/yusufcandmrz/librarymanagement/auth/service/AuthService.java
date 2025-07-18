package com.yusufcandmrz.librarymanagement.auth.service;

import com.yusufcandmrz.librarymanagement.auth.dto.request.RegisterRequest;
import com.yusufcandmrz.librarymanagement.auth.dto.request.LoginRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface AuthService {

    public void register(RegisterRequest request);

    public Boolean login(LoginRequest request);

    public void deleteAccountById(UUID id);
}
