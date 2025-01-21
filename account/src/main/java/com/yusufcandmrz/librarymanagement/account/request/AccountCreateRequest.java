package com.yusufcandmrz.librarymanagement.account.request;

import com.yusufcandmrz.librarymanagement.account.entity.Status;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AccountCreateRequest {

    @NotBlank(message = "First name is required")
    String firstName;

    @NotBlank(message = "Last name is required")
    String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8, max = 20, message = "Password should be between 8 and 20 characters")
    String password;

    @NotBlank(message = "Confirm password is required")
    String confirmPassword;

    @NotBlank(message = "Role is required")
    Status role;

    public boolean isPasswordMatch() {
        return password.equals(confirmPassword);
    }
}
