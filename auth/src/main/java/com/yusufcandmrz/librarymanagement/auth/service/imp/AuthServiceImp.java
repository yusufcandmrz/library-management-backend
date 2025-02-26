package com.yusufcandmrz.librarymanagement.auth.service.imp;

import com.yusufcandmrz.librarymanagement.auth.dto.request.AccountCreateRequest;
import com.yusufcandmrz.librarymanagement.auth.dto.request.LoginRequest;
import com.yusufcandmrz.librarymanagement.auth.dto.request.RegisterRequest;
import com.yusufcandmrz.librarymanagement.auth.entity.Account;
import com.yusufcandmrz.librarymanagement.auth.entity.Auth;
import com.yusufcandmrz.librarymanagement.auth.manager.AccountManager;
import com.yusufcandmrz.librarymanagement.auth.repository.AuthRepository;
import com.yusufcandmrz.librarymanagement.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class AuthServiceImp implements AuthService {

    AuthRepository authRepository;
    ModelMapper modelMapper;
    AccountManager accountManager;

    @Autowired
    public AuthServiceImp(AuthRepository authRepository, ModelMapper modelMapper, AccountManager accountManager) {
        this.authRepository = authRepository;
        this.modelMapper = modelMapper;
        this.accountManager = accountManager;
    }

    @Override
    public Auth register(RegisterRequest request) {
        if (!request.isPasswordsMatches()) {
            throw new RuntimeException("Passwords do not match");
        } else if (authRepository.existsByUsername(request.getUsername())) {
            throw new RuntimeException("Username already exists");
        } else {
            Auth auth = authRepository.save(modelMapper.map(request, Auth.class));
            AccountCreateRequest accountCreateRequest = new AccountCreateRequest();
            accountCreateRequest.setId(auth.getId());
            accountManager.createAccount(accountCreateRequest);
            return auth;
        }
    }

    @Override
    public Boolean login(LoginRequest request) {
        return authRepository.existsByUsernameAndPassword(request.getUsername(), request.getPassword());
    }
}
