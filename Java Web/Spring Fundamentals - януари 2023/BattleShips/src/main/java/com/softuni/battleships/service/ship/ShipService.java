package com.softuni.battleships.service.ship;

import com.softuni.battleships.model.dto.*;
import com.softuni.battleships.model.entity.ShipEntity;

import java.util.Set;

public interface ShipService {
    ShipEntity findByShipName(String shipName);

    void addShip(AddShipDTO addShipDTO);

    Set<AllShipDTO> findAllShips();

    Set<ShipOwnedByUserDTO> findAllShipsOwnedByTheUser();

    Set<ShipOwnedNotByUserDTO> findAllShipsNotOwnedByTheUser();

    void battle(ShipsForBattleDTO shipsForBattleDTO);
}
