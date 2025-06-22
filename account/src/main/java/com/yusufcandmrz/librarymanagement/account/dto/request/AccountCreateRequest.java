package com.yusufcandmrz.librarymanagement.account.dto.request;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

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
