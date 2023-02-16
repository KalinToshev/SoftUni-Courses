package com.softuni.mobilele.web;

import com.softuni.mobilele.domain.models.RegisterUserModel;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users/")
public class RegisterController {
    @GetMapping("register")
    public ModelAndView getRegisterPage(ModelAndView modelAndView) {
        modelAndView.setViewName("auth-register");
        modelAndView.addObject("user", new RegisterUserModel());
        return modelAndView;
    }

    @PostMapping("register")
    public ModelAndView registerUser(ModelAndView modelAndView, @Valid @ModelAttribute RegisterUserModel user, BindingResult bindingResult, RedirectAttributes rAtt) {
        if (bindingResult.hasErrors()) {
            rAtt.addFlashAttribute("user", user);
            rAtt.addFlashAttribute("org.springframework.validation.BindingResult.RegisterUserModel", bindingResult);
            modelAndView.setViewName("redirect:/register");
        }

        modelAndView.setViewName("index");

        return modelAndView;
    }
}
