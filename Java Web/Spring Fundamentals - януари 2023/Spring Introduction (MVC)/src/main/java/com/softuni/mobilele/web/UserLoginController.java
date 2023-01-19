package com.softuni.mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserLoginController {

    @RequestMapping(value = "/users/login", method = RequestMethod.GET)
    public String openLogin() {
        return "auth-login.html";
    }

}
