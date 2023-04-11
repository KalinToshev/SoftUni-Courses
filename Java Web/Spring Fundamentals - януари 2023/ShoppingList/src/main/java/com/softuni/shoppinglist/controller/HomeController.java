package com.softuni.shoppinglist.controller;

import com.softuni.shoppinglist.model.entity.ProductEntity;
import com.softuni.shoppinglist.service.product.ProductService;
import com.softuni.shoppinglist.util.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.Set;

@Controller
public class HomeController {
    private final LoggedUser loggedUser;

    private final ProductService productService;

    @Autowired
    public HomeController(LoggedUser loggedUser, ProductService productService) {
        this.loggedUser = loggedUser;
        this.productService = productService;
    }

    @GetMapping("/")
    public String getIndex() {
        if (this.loggedUser.isLogged()) {
            return "redirect:/home";
        }

        return "index";
    }

    @GetMapping("/home")
    public String getHome(Model model) {
        if (!this.loggedUser.isLogged()) {
            return "redirect:/";
        }

        Set<ProductEntity> foods = this.productService.getFoodProducts();

        model.addAttribute("foodProducts", foods);

        Set<ProductEntity> drinks = this.productService.getDrinkProducts();

        model.addAttribute("drinkProducts", drinks);

        Set<ProductEntity> households = this.productService.getHouseholdProducts();

        model.addAttribute("householdProducts", households);

        Set<ProductEntity> other = this.productService.getOtherProducts();

        model.addAttribute("otherProducts", other);

        BigDecimal totalPrice = this.productService.totalPriceOfAllProducts();

        model.addAttribute("totalProductsPrice", totalPrice);

        return "home";
    }
}
