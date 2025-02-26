package com.yusufcandmrz.librarymanagement.account.dto.request;

import lombok.*;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AccountCreateRequest {

    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
}
