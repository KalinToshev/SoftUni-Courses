package com.softuni.battleships.service.category;

import com.softuni.battleships.model.entity.CategoryEntity;
import com.softuni.battleships.model.enums.CategoryEnum;

public interface CategoryService {
    void initCategories();

    CategoryEntity findByCategory(CategoryEnum category);
}
