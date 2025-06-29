package com.yusufcandmrz.librarymanagement.auth.service.imp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yusufcandmrz.librarymanagement.account.exception.NotFoundException;
import com.yusufcandmrz.librarymanagement.auth.dto.request.AccountCreateRequest;
import com.yusufcandmrz.librarymanagement.auth.dto.request.LoginRequest;
import com.yusufcandmrz.librarymanagement.auth.dto.request.RegisterRequest;
import com.yusufcandmrz.librarymanagement.auth.dto.response.AuthDto;
import com.yusufcandmrz.librarymanagement.auth.entity.Auth;
import com.yusufcandmrz.librarymanagement.auth.entity.Status;
import com.yusufcandmrz.librarymanagement.auth.exception.BadRequestException;
import com.yusufcandmrz.librarymanagement.auth.manager.AccountManager;
import com.yusufcandmrz.librarymanagement.auth.repository.AuthRepository;
import com.yusufcandmrz.librarymanagement.auth.service.AuthService;
import com.yusufcandmrz.librarymanagement.auth.kafka.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.Optional;
import java.util.UUID;

@Service
public class AuthServiceImp implements AuthService {

    AuthRepository authRepository;
    ModelMapper modelMapper;
    AccountManager accountManager;
    KafkaProducer kafkaProducer;
    ObjectMapper objectMapper;


    @Autowired
    public AuthServiceImp(AuthRepository authRepository, ModelMapper modelMapper, AccountManager accountManager, KafkaProducer kafkaProducer, ObjectMapper objectMapper) {
        this.authRepository = authRepository;
        this.modelMapper = modelMapper;
        this.accountManager = accountManager;
        this.kafkaProducer = kafkaProducer;
        this.objectMapper = objectMapper;
    }

    @Override
    public void register(RegisterRequest request) {
        if (!request.isPasswordsMatches()) {
            throw new BadRequestException("Passwords do not match");
        }
        if (authRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already exists");
        }
        Auth auth = authRepository.save(modelMapper.map(request, Auth.class));
        try {
            AccountCreateRequest accountCreateRequest = new AccountCreateRequest();
            accountCreateRequest.setId(auth.getId());
            accountCreateRequest.setEmail(auth.getEmail());
            accountManager.createAccount(accountCreateRequest);
        } catch (RuntimeException e) {
            authRepository.delete(auth);
            throw new RuntimeException(e);
        }
        /* try {
            String message = objectMapper.writeValueAsString((Map.of("event", "AUTH_REGISTERED", "id", auth.getId(), "email", auth.getEmail())));
            kafkaProducer.sendRegisteredEvent(message);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } */
    }

    @Override
    public Boolean login(LoginRequest request) {
        return authRepository.existsByEmailAndPassword(request.getEmail(), request.getPassword());
    }

    @Override
    public void deleteAccountById(UUID id) {
        Auth auth = authRepository.findById(id).orElseThrow(() -> new NotFoundException("Account did not found"));
        auth.setStatus(Status.INACTIVE);
        authRepository.save(auth);
        try {
            accountManager.deleteAccountById(id);
        } catch (RuntimeException e) {
            auth.setStatus(Status.ACTIVE);
            authRepository.save(auth);
            throw new RuntimeException(e);
        }
    }

    public AuthDto convertToDto(Auth auth) {
        return modelMapper.map(auth, AuthDto.class);
    }
}
