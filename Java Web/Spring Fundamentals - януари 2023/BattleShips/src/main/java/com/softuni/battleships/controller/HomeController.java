package com.softuni.battleships.controller;

import com.softuni.battleships.model.dto.AllShipDTO;
import com.softuni.battleships.model.dto.ShipOwnedByUserDTO;
import com.softuni.battleships.model.dto.ShipOwnedNotByUserDTO;
import com.softuni.battleships.model.dto.ShipsForBattleDTO;
import com.softuni.battleships.service.ship.ShipService;
import com.softuni.battleships.util.LoggedUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Set;

@Controller
public class HomeController {
    private final LoggedUser loggedUser;

    private final ShipService shipService;

    @Autowired
    public HomeController(LoggedUser loggedUser, ShipService shipService) {
        this.loggedUser = loggedUser;
        this.shipService = shipService;
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

        Set<AllShipDTO> allShips = this.shipService.findAllShips();

        model.addAttribute("allShips", allShips);

        Set<ShipOwnedByUserDTO> allShipsOwnedByUser = this.shipService.findAllShipsOwnedByTheUser();

        model.addAttribute("allShipsOwnedByUser", allShipsOwnedByUser);

        Set<ShipOwnedNotByUserDTO> allShipsNotOwnedByUser = this.shipService.findAllShipsNotOwnedByTheUser();

        model.addAttribute("allShipsNotOwnedByUser", allShipsNotOwnedByUser);

        return "home";
    }

    @ModelAttribute
    public ShipsForBattleDTO shipsForBattleDTO() {
        return new ShipsForBattleDTO();
    }
}
