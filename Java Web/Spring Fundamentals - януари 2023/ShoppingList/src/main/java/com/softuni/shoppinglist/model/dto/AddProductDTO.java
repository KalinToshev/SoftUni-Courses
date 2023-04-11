package com.softuni.shoppinglist.model.dto;

import com.softuni.shoppinglist.model.entity.CategoryEntity;
import com.softuni.shoppinglist.model.enums.CategoryEnum;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddProductDTO {
    @Size(message = "Name field must contain from 3 to 20 characters (inclusive)!", min = 3, max = 20)
    @NotBlank(message = "Name field cannot be blank!")
    private String name;

    @Size(message = "Description field must contain minimum 5 (inclusive)!", min = 5)
    @NotBlank(message = "Description field cannot be blank!")
    private String description;

    @Positive(message = "Price field must be a positive number!")
    @NotNull(message = "Price field cannot be null!")
    private BigDecimal price;

    @FutureOrPresent(message = "Needed before field should not be in the past!")
    @NotNull(message = "Before field cannot be null!")
    private LocalDateTime neededBefore;

    @NotNull(message = "Category field should not be null!")
    private CategoryEnum category;
}
