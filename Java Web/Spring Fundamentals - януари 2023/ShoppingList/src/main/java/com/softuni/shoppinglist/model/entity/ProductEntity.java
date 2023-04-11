package com.softuni.shoppinglist.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "products")
public class ProductEntity extends BaseEntity {
    @Size(message = "Name field must contain from 3 to 20 characters (inclusive)!", min = 3, max = 20)
    @NotBlank(message = "Name field cannot be blank!")
    @Column(name = "name", unique = true, length = 20)
    private String name;

    @Size(message = "Description field must contain minimum 5 (inclusive)!", min = 5)
    @NotBlank(message = "Description field cannot be blank!")
    @Column(name = "description")
    private String description;

    @Positive(message = "Price field must be a positive number!")
    @Column(name = "price")
    private BigDecimal price;

    @FutureOrPresent(message = "Needed before field should not be in the past!")
    @Column(name = "needed_before")
    private LocalDateTime neededBefore;

    @NotNull(message = "Category field should not be null!")
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

}