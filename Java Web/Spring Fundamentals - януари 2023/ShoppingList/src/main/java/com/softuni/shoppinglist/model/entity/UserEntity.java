package com.softuni.shoppinglist.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Size(message = "Username field must contain from 3 to 20 characters (inclusive)!", min = 3, max = 20)
    @NotBlank(message = "Username field cannot be blank!")
    @Column(name = "username", nullable = false, unique = true, length = 20)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Email(message = "Please provide a properly formatted email address")
    @NotBlank(message = "Email field cannot be blank!")
    @Column(name = "email", nullable = false, unique = true)
    private String email;
}