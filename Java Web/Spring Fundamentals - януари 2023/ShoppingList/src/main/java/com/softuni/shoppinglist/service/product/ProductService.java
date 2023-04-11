package com.softuni.shoppinglist.service.product;

import com.softuni.shoppinglist.model.dto.AddProductDTO;
import com.softuni.shoppinglist.model.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.Set;

public interface ProductService {
    void addProduct(AddProductDTO addProductDTO);

    Set<ProductEntity> getFoodProducts();

    Set<ProductEntity> getDrinkProducts();

    Set<ProductEntity> getHouseholdProducts();

    Set<ProductEntity> getOtherProducts();

    void buyProduct(Long id);

    BigDecimal totalPriceOfAllProducts();

    void buyAllProducts();
}
