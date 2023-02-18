package com.softuni.spotify_playlist_application.validation.annotation;

import com.softuni.spotify_playlist_application.validation.UniquePerformerValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = UniquePerformerValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface UniquePerformer {
    String message() default "Performer already exist";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
