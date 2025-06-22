package com.yusufcandmrz.librarymanagement.auth.dto.request;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginRequest {
    String email;
    String password;
}
