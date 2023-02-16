package com.softuni.mobilele.domain.models;

import com.softuni.mobilele.domain.entities.UserRole;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class RegisterUserModel {
    private String username; // –  username of the user.

    private String password; // – password of the user.

    private String firstName; // –  first name of the user.

    private String lastName; // –  last name of the user.

    private UserRole role; // –  user's role (User or Admin).

    private LocalDateTime created; // – a date and time.

    private LocalDateTime modified; // – a date and time.
}
