package com.softuni.battleships.model.dto;

import com.softuni.battleships.validation.validation.annotation.UniqueEmail;
import com.softuni.battleships.validation.validation.annotation.UniqueUsername;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    @Size(message = "Username field should be from 3 to 10 characters long (inclusive)!", min = 3, max = 10)
    @NotBlank(message = "Username field cannot be blank!")
    @UniqueUsername
    private String username;

    @Size(message = "Full name field should be from 5 to 20 characters long (inclusive)!", min = 5, max = 20)
    @NotBlank(message = "Full name field cannot be blank!")
    private String fullName;

    @Size(message = "Password field should be from 3 characters long (inclusive)!", min = 3)
    @NotBlank(message = "Password field cannot be blank!")
    private String password;

    @Size(message = "Confirm password field should be from 3 characters long (inclusive)!", min = 3)
    @NotBlank(message = "Confirm password field cannot be blank!")
    private String confirmPassword;

    @Email(message = "Email field must be valid!")
    @NotBlank(message = "Email field cannot be blank!")
    @UniqueEmail
    private String email;
}
