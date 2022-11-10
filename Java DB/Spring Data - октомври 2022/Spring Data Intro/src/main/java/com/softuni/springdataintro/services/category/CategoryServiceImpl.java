package com.softuni.springdataintro.services.category;

import com.softuni.springdataintro.domain.entities.Category;
import com.softuni.springdataintro.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {

        this.categoryRepository = categoryRepository;

    }

    @Override
    public void seedCategories(List<Category> categories) {

        this.categoryRepository.saveAll(categories);

    }

    @Override
    public boolean isDataSeeded() {

        return this.categoryRepository.count() > 0;

    }

    @Override
    public Set<Category> getRandomCategories() {

        long randomAuthorId = new Random().nextLong(1L, this.categoryRepository.count()) + 1L;

        return Set.of(this.categoryRepository.findById(randomAuthorId)
                    .orElseThrow(NoSuchElementException::new));


    }

}
