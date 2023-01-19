package com.softuni.mobilele.web;

import com.softuni.mobilele.services.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserRegisterController {

    private final UserService userService;

    public UserRegisterController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users/register", method = RequestMethod.GET)
    public String openRegister() {
        return "auth-register.html";
    }

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public String addUser(@RequestParam("firstName") String firstName,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("roles") String role) {

        

        return "redirect:/";
    }

}
