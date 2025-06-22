package com.yusufcandmrz.librarymanagement.auth.dto.request;

import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RegisterRequest {
    String email;
    String password;
    String passwordAgain;

    public Boolean isPasswordsMatches() {
        return password.equals(passwordAgain);
    }
}
