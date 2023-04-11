package com.softuni.shoppinglist.validation.validation;

import com.softuni.shoppinglist.service.user.UserService;
import com.softuni.shoppinglist.validation.validation.annotation.UniqueUsername;
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