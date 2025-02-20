package com.yusufcandmrz.librarymanagement.auth.dto.response;

import com.yusufcandmrz.librarymanagement.auth.entity.Status;

import java.sql.Timestamp;
import java.util.UUID;

public class RegisterResponse {
    UUID id;
    String email;
    String password;
    Status status;
    Timestamp createdAt;
    Timestamp updatedAt;
}