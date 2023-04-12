package com.softuni.battleships.validation.validation;

import com.softuni.battleships.service.user.UserService;
import com.softuni.battleships.validation.validation.annotation.UniqueUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    private final UserService userService;

    public UniqueUsernameValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String username, ConstraintValidatorContext context) {
        return this.userService.findByUsername(username) == null;
    }
}