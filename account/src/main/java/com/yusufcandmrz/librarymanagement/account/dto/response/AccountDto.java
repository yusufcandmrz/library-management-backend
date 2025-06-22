package com.yusufcandmrz.librarymanagement.account.dto.response;

import com.yusufcandmrz.librarymanagement.account.entity.Status;

import java.util.UUID;
import java.sql.Timestamp;

public class AccountDto {
    UUID id;
    String firstName;
    String lastName;
    String email;
    String phoneNumber;
    Status status;
    Timestamp createdAt;
    Timestamp updatedAt;
}
