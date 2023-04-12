package com.softuni.battleships.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    @Size(message = "Username field should be from 3 to 10 characters long (inclusive)!", min = 3, max = 10)
    @NotBlank(message = "Username field cannot be blank!")
    @Column(name = "username", nullable = false, unique = true, length = 10)
    private String username;

    @Size(message = "Full name field should be from 5 to 20 characters long (inclusive)!", min = 5, max = 20)
    @NotBlank(message = "Full name field cannot be blank!")
    @Column(name = "full_name", nullable = false, length = 20)
    private String fullName;

    @Column(name = "password", nullable = false)
    private String password;

    @Email(message = "Email field must be valid!")
    @NotBlank(message = "Email field cannot be blank!")
    @Column(name = "email", nullable = false, unique = true)
    private String email;
}