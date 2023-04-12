package com.softuni.battleships.model.entity;

import com.softuni.battleships.model.enums.CategoryEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity {
    @Column(name = "description", columnDefinition = "TEXT")
    @Lob
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, unique = true)
    private CategoryEnum category;
}