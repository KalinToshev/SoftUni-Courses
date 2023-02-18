package com.softuni.spotify_playlist_application.controller.user;

import com.softuni.spotify_playlist_application.model.dtos.LoginDTO;
import com.softuni.spotify_playlist_application.model.dtos.RegisterDTO;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("/users")
public interface UserController {
    @GetMapping("/login")
    String returnLoginPage(Model model);

    @PostMapping("/login")
    String loginConfirm(@Valid LoginDTO loginDTO, BindingResult result, RedirectAttributes redirectAttributes);

    @GetMapping("/register")
    String returnRegisterPage();

    @PostMapping("/register")
    String registerConfirm(@Valid RegisterDTO registerDTO, BindingResult result, RedirectAttributes redirectAttributes);

    @GetMapping("/logout")
    String logout();
}
