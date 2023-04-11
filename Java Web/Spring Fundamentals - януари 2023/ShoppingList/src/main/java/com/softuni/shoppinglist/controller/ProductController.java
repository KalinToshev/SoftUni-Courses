package com.softuni.shoppinglist.controller;

import com.softuni.shoppinglist.model.dto.AddProductDTO;
import com.softuni.shoppinglist.service.product.ProductService;
import com.softuni.shoppinglist.util.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ProductController {
    private final LoggedUser loggedUser;

    private final ProductService productService;

    @Autowired
    public ProductController(LoggedUser loggedUser, ProductService productService) {
        this.loggedUser = loggedUser;
        this.productService = productService;
    }

    @GetMapping("/product/add")
    public String getAddProduct() {
        if (!this.loggedUser.isLogged()) {
            return "redirect:/";
        }

        return "product-add";
    }

    @PostMapping("/product/add")
    public String addProductConfirm(@Valid AddProductDTO addProductDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("addProductDTO", addProductDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addProductDTO", bindingResult);

            return "redirect:/product/add";
        }

        this.productService.addProduct(addProductDTO);

        return "redirect:/home";
    }

    @GetMapping("/product/buy/{id}")
    public String buyProduct(@PathVariable Long id) {
        if (!loggedUser.isLogged()) {
            return "redirect:/";
        }

        this.productService.buyProduct(id);

        return "redirect:/home";
    }

    @GetMapping("/product/buy/all")
    public String buyAllProducts() {
        if (!loggedUser.isLogged()) {
            return "redirect:/";
        }

        this.productService.buyAllProducts();

        return "redirect:/home";
    }

    @ModelAttribute
    public AddProductDTO addProductDTO() {
        return new AddProductDTO();
    }
}
