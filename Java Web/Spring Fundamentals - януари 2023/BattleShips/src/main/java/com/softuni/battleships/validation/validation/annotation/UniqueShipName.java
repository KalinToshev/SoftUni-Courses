package com.softuni.battleships.validation.validation.annotation;

import com.softuni.battleships.validation.validation.UniqueShipNameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniqueShipNameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueShipName {
    String message() default "Ship with this name already exist!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
