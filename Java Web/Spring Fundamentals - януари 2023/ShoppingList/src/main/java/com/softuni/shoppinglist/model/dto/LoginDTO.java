package com.softuni.shoppinglist.model.dto;

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
    @Size(message = "Username field must contain from 3 to 20 characters (inclusive)!", min = 3, max = 20)
    @NotBlank(message = "Username field cannot be blank!")
    private String username;

    @Size(message = "Password field must contain from 3 to 20 characters (inclusive)!", min = 3, max = 20)
    @NotBlank(message = "Password field cannot be blank!")
    private String password;
}
