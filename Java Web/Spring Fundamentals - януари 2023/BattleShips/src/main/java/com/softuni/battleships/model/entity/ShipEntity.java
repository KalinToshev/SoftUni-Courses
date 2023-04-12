package com.softuni.battleships.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ships")
public class ShipEntity extends BaseEntity {
    @Size(message = "Name field should be from 2 to 10 characters long (inclusive)!", min = 2, max = 10)
    @NotBlank(message = "Name field cannot be blank!")
    @Column(name = "name", nullable = false, unique = true, length = 10)
    private String name;

    @Positive(message = "Health field should be positive number!")
    @NotNull(message = "Health field cannot be null!")
    @Column(name = "health", nullable = false)
    private Integer health;

    @Positive(message = "Power field should be positive number!")
    @NotNull(message = "Power field cannot be null!")
    @Column(name = "power", nullable = false)
    private Integer power;

    @NotNull(message = "Owner field cannot be null!")
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "owner_id")
    private UserEntity owner;

    @NotNull(message = "Category field cannot be null!")
    @ManyToOne(cascade = CascadeType.MERGE, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @NotNull(message = "Created field cannot be null!")
    @PastOrPresent(message = "Created field should not be in the future!")
    @Column(name = "created", nullable = false)
    private LocalDate created;
}