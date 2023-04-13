package com.plannerapp.controller;

import com.plannerapp.model.dto.LoginDTO;
import com.plannerapp.model.dto.RegisterDTO;
import com.plannerapp.service.task.TaskService;
import com.plannerapp.service.user.UserService;
import com.plannerapp.util.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.transaction.Transactional;
import javax.validation.Valid;

@Controller
public class UserController {
    private final LoggedUser loggedUser;

    private final UserService userService;

    private final TaskService taskService;

    @Autowired
    public UserController(LoggedUser loggedUser, UserService userService, TaskService taskService) {
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.taskService = taskService;
    }

    @GetMapping("/user/login")
    public String login() {
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
    public String register() {
        if (this.loggedUser.isLogged()) {
            return "redirect:/home";
        }

        return "register";
    }

    @PostMapping("/user/register")
    public String registerConfirm(@Valid RegisterDTO registerDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!registerDTO.getPassword().equals(registerDTO.getConfirmPassword())) {
            bindingResult.addError(
                    new FieldError(
                            "differentConfirmPassword",
                            "confirmPassword",
                            "Passwords must be the same!"));
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("registerDTO", registerDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.registerDTO", bindingResult);

            return "redirect:/user/register";
        }

        this.userService.register(registerDTO);

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

    @Transactional
    @GetMapping("/task/add/{id}")
    public String assignTaskToUser(@PathVariable Long id) {
        this.taskService.assignTask(id);

        return "redirect:/home";
    }

    @Transactional
    @GetMapping("/task/remove/{id}")
    public String removeTask(@PathVariable Long id) {
        this.taskService.removeTask(id);

        return "redirect:/home";
    }

    @Transactional
    @GetMapping("/task/return/{id}")
    public String returnTask(@PathVariable Long id) {
        this.taskService.returnTask(id);

        return "redirect:/home";
    }

    @ModelAttribute
    public LoginDTO loginDTO() {
        return new LoginDTO();
    }

    @ModelAttribute
    public void addAttribute(Model model) {
        model.addAttribute("validCredentials");
    }

    @ModelAttribute
    public RegisterDTO registerDTO() {
        return new RegisterDTO();
    }
}
