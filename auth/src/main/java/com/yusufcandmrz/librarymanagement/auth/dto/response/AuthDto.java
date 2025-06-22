package com.yusufcandmrz.librarymanagement.auth.dto.response;

import com.yusufcandmrz.librarymanagement.auth.entity.Role;
import com.yusufcandmrz.librarymanagement.auth.entity.Status;

import java.sql.Timestamp;
import java.util.UUID;

public class AuthDto {
    UUID id;
    String email;
    String password;
    Role role;
    Status status;
    Timestamp createdAt;
    Timestamp updatedAt;
}
