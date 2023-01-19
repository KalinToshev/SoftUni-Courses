package com.softuni.mobilele.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BrandController {

    @RequestMapping(value = "/brands/all", method = RequestMethod.GET)
    public String openAllBrands() {
        return "brands.html";
    }

}
