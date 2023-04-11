package com.softuni.shoppinglist.service.category;

import com.softuni.shoppinglist.model.entity.CategoryEntity;
import com.softuni.shoppinglist.model.enums.CategoryEnum;
import com.softuni.shoppinglist.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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
            Arrays.stream(CategoryEnum.values())
                    .forEach(categoryEnum -> {
                        CategoryEntity category = new CategoryEntity();

                        category.setCategoryEnum(categoryEnum);

                        category.setDescription("...");

                        this.categoryRepository.save(category);
                    });
        }
    }

    @Override
    public CategoryEntity findCategory(CategoryEnum category) {
        return categoryRepository.findByCategoryEnum(category).orElseThrow(() -> new IllegalArgumentException("Category with this name was not found!"));
    }
}
