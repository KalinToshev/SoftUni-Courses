package com.softuni.springdataintro.services.category;

import com.softuni.springdataintro.domain.entities.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {

    void seedCategories(List<Category> categories);

    boolean isDataSeeded();

    Set<Category> getRandomCategories();

}
