package com.softuni.shoppinglist.model.entity;

import com.softuni.shoppinglist.model.enums.CategoryEnum;
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
    @Enumerated(EnumType.STRING)
    @Column(name = "category_enum", unique = true)
    private CategoryEnum categoryEnum;

    @Column(name = "description")
    private String description;

}