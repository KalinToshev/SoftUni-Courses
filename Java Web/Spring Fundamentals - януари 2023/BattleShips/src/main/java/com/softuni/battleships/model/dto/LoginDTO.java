package com.softuni.battleships.model.dto;

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
public class LoginDTO {
    @Size(message = "Username field should be from 3 to 10 characters long (inclusive)!", min = 3, max = 10)
    @NotBlank(message = "Username field cannot be blank!")
    private String username;

    @Size(message = "Password field should be from 3 characters long (inclusive)!", min = 3)
    @NotBlank(message = "Password field cannot be blank!")
    private String password;
}
