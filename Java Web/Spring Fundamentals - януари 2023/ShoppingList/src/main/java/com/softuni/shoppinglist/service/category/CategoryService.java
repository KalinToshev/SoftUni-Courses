package com.softuni.shoppinglist.service.category;

import com.softuni.shoppinglist.model.entity.CategoryEntity;
import com.softuni.shoppinglist.model.enums.CategoryEnum;

public interface CategoryService {
    void initCategories();

    CategoryEntity findCategory(CategoryEnum category);
}
