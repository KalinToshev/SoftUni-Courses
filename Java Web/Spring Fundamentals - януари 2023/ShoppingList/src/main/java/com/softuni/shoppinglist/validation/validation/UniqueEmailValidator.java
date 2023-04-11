package com.softuni.shoppinglist.validation.validation;

import com.softuni.shoppinglist.service.user.UserService;
import com.softuni.shoppinglist.validation.validation.annotation.UniqueEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

    private final UserService userService;

    public UniqueEmailValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        return this.userService.findByEmail(email) == null;
    }
}