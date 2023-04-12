package com.softuni.battleships.repository;

import com.softuni.battleships.model.entity.CategoryEntity;
import com.softuni.battleships.model.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByCategory(CategoryEnum category);
}