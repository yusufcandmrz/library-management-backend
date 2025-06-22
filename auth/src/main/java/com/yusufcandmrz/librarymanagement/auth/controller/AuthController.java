package com.yusufcandmrz.librarymanagement.auth.controller;

import com.yusufcandmrz.librarymanagement.auth.dto.request.LoginRequest;
import com.yusufcandmrz.librarymanagement.auth.dto.request.RegisterRequest;
import com.yusufcandmrz.librarymanagement.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody RegisterRequest request) {
        authService.register(request);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Boolean> login(@RequestBody LoginRequest request) {
        return new ResponseEntity<Boolean>(authService.login(request), HttpStatus.OK);
    }
}
