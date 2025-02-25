package com.yusufcandmrz.librarymanagement.auth.dto.request;

import com.yusufcandmrz.librarymanagement.auth.entity.Role;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RegisterRequest {
    String username;
    String password;
    String passwordAgain;
    Role role;

    public Boolean isPasswordsMatches() {
        return password.equals(passwordAgain);
    }
}
