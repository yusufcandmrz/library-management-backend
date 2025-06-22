package com.yusufcandmrz.librarymanagement.auth.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AccountCreateRequest {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
}
