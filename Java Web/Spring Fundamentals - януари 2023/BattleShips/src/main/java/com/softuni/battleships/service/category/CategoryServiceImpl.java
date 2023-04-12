package com.softuni.battleships.service.category;

import com.softuni.battleships.model.entity.CategoryEntity;
import com.softuni.battleships.model.enums.CategoryEnum;
import com.softuni.battleships.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initCategories() {
        if (this.categoryRepository.count() == 0) {
            for (CategoryEnum categoryEnum : CategoryEnum.values()) {
                CategoryEntity category = new CategoryEntity();

                category.setCategory(categoryEnum);

                category.setDescription("...");

                this.categoryRepository.save(category);
            }
        }
    }

    @Override
    public CategoryEntity findByCategory(CategoryEnum category) {
        return categoryRepository.findByCategory(category).orElseThrow(() -> new IllegalArgumentException("Ship with this category does not exist!"));
    }
}
