package com.softuni.shoppinglist.repository;

import com.softuni.shoppinglist.model.entity.ProductEntity;
import com.softuni.shoppinglist.model.enums.CategoryEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    Set<ProductEntity> findByCategory_CategoryEnum(CategoryEnum categoryEnum);
}