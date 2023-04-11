package com.softuni.shoppinglist.controller;

import com.softuni.shoppinglist.model.dto.LoginDTO;
import com.softuni.shoppinglist.model.dto.RegisterUserDTO;
import com.softuni.shoppinglist.service.user.UserService;
import com.softuni.shoppinglist.util.LoggedUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    private final LoggedUser loggedUser;

    private final UserService userService;

    @Autowired
    public UserController(LoggedUser loggedUser, UserService userService) {
        this.loggedUser = loggedUser;
        this.userService = userService;
    }

    @GetMapping("/user/login")
    public String getLogin() {
        if (this.loggedUser.isLogged()) {
            return "redirect:/home";
        }

        return "login";
    }

    @PostMapping("/user/login")
    public String loginConfirm(@Valid LoginDTO loginDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("loginDTO", loginDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.loginDTO", bindingResult);

            return "redirect:/user/login";
        }

        boolean validCredentials = this.userService.checkCredentials(loginDTO.getUsername(), loginDTO.getPassword());

        if (!validCredentials) {
            redirectAttributes
                    .addFlashAttribute("loginDTO", loginDTO)
                    .addFlashAttribute("validCredentials", false);
            return "redirect:/user/login";
        }

        this.userService.login(loginDTO.getUsername());

        return "redirect:/home";
    }

    @GetMapping("/user/register")
    public String getRegister() {
        if (this.loggedUser.isLogged()) {
            return "redirect:/home";
        }

        return "register";
    }

    @PostMapping("/user/register")
    public String registerConfirm(@Valid RegisterUserDTO registerUserDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!registerUserDTO.getPassword().equals(registerUserDTO.getConfirmPassword())) {
            bindingResult.addError(
                    new FieldError(
                            "differentConfirmPassword",
                            "confirmPassword",
                            "Passwords must be the same!"));
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("registerUserDTO", registerUserDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.registerUserDTO", bindingResult);

            return "redirect:/user/register";
        }

        this.userService.register(registerUserDTO);

        return "redirect:/home";
    }

    @GetMapping("/user/logout")
    public String logout() {
        if (!this.loggedUser.isLogged()) {
            return "redirect:/user/login";
        }

        this.userService.logout();

        return "redirect:/";
    }

    @ModelAttribute
    public RegisterUserDTO registerUserDTO() {
        return new RegisterUserDTO();
    }

    @ModelAttribute
    public void addAttribute(Model model) {
        model.addAttribute("validCredentials");
    }

    @ModelAttribute
    public LoginDTO loginDTO() {
        return new LoginDTO();
    }
}
