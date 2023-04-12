package com.softuni.battleships.init;

import com.softuni.battleships.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitCategories implements CommandLineRunner {
    private final CategoryService categoryService;

    @Autowired
    public InitCategories(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        this.categoryService.initCategories();
    }
}
