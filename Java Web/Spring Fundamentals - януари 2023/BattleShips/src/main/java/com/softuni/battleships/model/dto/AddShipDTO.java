package com.softuni.battleships.model.dto;

import com.softuni.battleships.model.enums.CategoryEnum;
import com.softuni.battleships.validation.validation.annotation.UniqueShipName;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddShipDTO {
    @Size(message = "Name field should be from 2 to 10 characters long (inclusive)!", min = 2, max = 10)
    @NotBlank(message = "Name field cannot be blank!")
    @UniqueShipName
    private String name;

    @Positive(message = "Health field should be positive number!")
    @NotNull(message = "Health field cannot be null!")
    private Integer health;

    @Positive(message = "Power field should be positive number!")
    @NotNull(message = "Power field cannot be null!")
    private Integer power;

    @NotNull(message = "Category field cannot be null!")
    private CategoryEnum category;

    @NotNull(message = "Created field cannot be null!")
    @PastOrPresent(message = "Created field should not be in the future!")
    private LocalDate created;
}
