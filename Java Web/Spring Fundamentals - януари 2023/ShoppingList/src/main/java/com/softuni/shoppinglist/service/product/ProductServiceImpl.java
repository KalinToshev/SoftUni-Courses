package com.softuni.shoppinglist.service.product;

import com.softuni.shoppinglist.model.dto.AddProductDTO;
import com.softuni.shoppinglist.model.entity.ProductEntity;
import com.softuni.shoppinglist.model.enums.CategoryEnum;
import com.softuni.shoppinglist.repository.ProductRepository;
import com.softuni.shoppinglist.service.category.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {
    private static final CategoryEnum FOOD_CATEGORY = CategoryEnum.Food;

    private static final CategoryEnum DRINK_CATEGORY = CategoryEnum.Drink;

    private static final CategoryEnum HOUSEHOLD_CATEGORY = CategoryEnum.Household;

    private static final CategoryEnum OTHER_CATEGORY = CategoryEnum.Other;

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    private final CategoryService categoryService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ModelMapper modelMapper, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
        this.categoryService = categoryService;
    }

    @Override
    public void addProduct(AddProductDTO addProductDTO) {
        ProductEntity product = new ProductEntity();

        this.modelMapper.map(addProductDTO, product);

        product.setCategory(this.categoryService.findCategory(addProductDTO.getCategory()));

        this.productRepository.save(product);
    }

    @Override
    public Set<ProductEntity> getFoodProducts() {
        return productRepository.findByCategory_CategoryEnum(FOOD_CATEGORY);
    }

    @Override
    public Set<ProductEntity> getDrinkProducts() {
        return productRepository.findByCategory_CategoryEnum(DRINK_CATEGORY);
    }

    @Override
    public Set<ProductEntity> getHouseholdProducts() {
        return productRepository.findByCategory_CategoryEnum(HOUSEHOLD_CATEGORY);
    }

    @Override
    public Set<ProductEntity> getOtherProducts() {
        return productRepository.findByCategory_CategoryEnum(OTHER_CATEGORY);
    }

    @Override
    public void buyProduct(Long id) {
        this.productRepository.deleteById(id);
    }

    @Override
    public BigDecimal totalPriceOfAllProducts() {
        BigDecimal sum = BigDecimal.ZERO;

        for (ProductEntity productEntity : this.productRepository.findAll()) {
            sum = sum.add(productEntity.getPrice());
        }

        return sum;
    }

    @Override
    public void buyAllProducts() {
        this.productRepository.deleteAll();
    }
}
