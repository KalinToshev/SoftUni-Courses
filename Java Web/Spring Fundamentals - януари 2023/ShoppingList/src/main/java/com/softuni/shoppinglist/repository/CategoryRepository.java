package com.softuni.shoppinglist.repository;

import com.softuni.shoppinglist.model.entity.CategoryEntity;
import com.softuni.shoppinglist.model.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
    Optional<CategoryEntity> findByCategoryEnum(CategoryEnum categoryEnum);
}