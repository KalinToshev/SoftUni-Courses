package com.softuni.battleships.validation.validation;

import com.softuni.battleships.service.ship.ShipService;
import com.softuni.battleships.validation.validation.annotation.UniqueShipName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueShipNameValidator implements ConstraintValidator<UniqueShipName, String>  {
    private final ShipService shipService;

    public UniqueShipNameValidator(ShipService shipService) {
        this.shipService = shipService;
    }

    @Override
    public boolean isValid(String shipName, ConstraintValidatorContext context) {
        return this.shipService.findByShipName(shipName) == null;
    }
}
