package com.yusufcandmrz.librarymanagement.auth.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RegisterRequest {
    String email;
    String password;
    String passwordAgain;
}
