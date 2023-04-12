package com.softuni.battleships.controller;

import com.softuni.battleships.model.dto.AddShipDTO;
import com.softuni.battleships.model.dto.ShipsForBattleDTO;
import com.softuni.battleships.service.ship.ShipService;
import com.softuni.battleships.util.LoggedUser;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ShipController {
    private final ShipService shipService;

    private final LoggedUser loggedUser;

    @Autowired
    public ShipController(ShipService shipService, LoggedUser loggedUser) {
        this.shipService = shipService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/ship/add")
    public String getShipAdd() {
        if (!loggedUser.isLogged()) {
            return "redirect:/";
        }

        return "ship-add";
    }

    @PostMapping("/ship/add")
    public String addShip(@Valid AddShipDTO addShipDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("addShipDTO", addShipDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult.addShipDTO", bindingResult);

            return "redirect:/ship/add";
        }

        this.shipService.addShip(addShipDTO);

        return "redirect:/home";
    }

    @Transactional
    @PostMapping("/ship/battle")
    public String battle(ShipsForBattleDTO shipsForBattleDTO) {
        this.shipService.battle(shipsForBattleDTO);

        return "redirect:/home";
    }

    @ModelAttribute
    public AddShipDTO addShipDTO() {
        return new AddShipDTO();
    }
}
