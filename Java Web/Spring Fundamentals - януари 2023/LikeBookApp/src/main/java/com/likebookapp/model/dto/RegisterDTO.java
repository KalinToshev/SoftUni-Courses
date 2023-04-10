package com.likebookapp.model.dto;

import com.likebookapp.validation.annotation.UniqueEmail;
import com.likebookapp.validation.annotation.UniqueUsername;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisterDTO {
    @Size(message = "Username field must contain from 3 to 20 characters (inclusive)!", min = 3, max = 20)
    @NotBlank(message = "Username field cannot be blank!")
    @UniqueUsername
    private String username;

    @Size(message = "Password field must contain from 3 to 20 characters (inclusive)!", min = 3, max = 20)
    @NotBlank(message = "Password field cannot be blank!")
    private String password;

    @Size(message = "Confirm password field must contain from 3 to 20 characters (inclusive)!", min = 3, max = 20)
    @NotBlank(message = "Confirm password field cannot be blank!")
    private String confirmPassword;

    @Email(message = "Please provide a properly formatted email address")
    @NotBlank(message = "Email field cannot be blank!")
    @UniqueEmail
    private String email;
}
