package com.softuni.battleships.service.ship;

import com.softuni.battleships.model.dto.*;
import com.softuni.battleships.model.entity.ShipEntity;
import com.softuni.battleships.repository.ShipRepository;
import com.softuni.battleships.service.category.CategoryService;
import com.softuni.battleships.service.user.UserService;
import com.softuni.battleships.util.LoggedUser;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ShipServiceImpl implements ShipService {
    private final ShipRepository shipRepository;

    private final ModelMapper modelMapper;

    private final LoggedUser loggedUser;

    private final UserService userService;

    private final CategoryService categoryService;

    @Autowired
    public ShipServiceImpl(ShipRepository shipRepository, ModelMapper modelMapper, LoggedUser loggedUser, UserService userService, CategoryService categoryService) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.loggedUser = loggedUser;
        this.userService = userService;
        this.categoryService = categoryService;
    }

    @Override
    public ShipEntity findByShipName(String shipName) {
        return shipRepository.findByName(shipName);
    }

    @Override
    public void addShip(AddShipDTO addShipDTO) {
        ShipEntity ship = new ShipEntity();

        this.modelMapper.map(addShipDTO, ship);

        ship.setOwner(this.userService.findByUsername(loggedUser.getUsername()));

        ship.setCategory(this.categoryService.findByCategory(addShipDTO.getCategory()));

        this.shipRepository.save(ship);
    }

    @Override
    public Set<AllShipDTO> findAllShips() {
        Set<AllShipDTO> allShips = new HashSet<>();

        this.shipRepository.findAll().forEach(shipEntity -> {
            AllShipDTO allShipDTO = new AllShipDTO();

            this.modelMapper.map(shipEntity, allShipDTO);

            allShips.add(allShipDTO);
        });

        return allShips;
    }

    @Override
    public Set<ShipOwnedByUserDTO> findAllShipsOwnedByTheUser() {
        Set<ShipOwnedByUserDTO> allShipsOwnedByTheUser = new HashSet<>();

        this.shipRepository.findByOwner_Id(this.loggedUser.getId()).forEach(shipEntity -> {
            ShipOwnedByUserDTO shipOwnedByUserDTO = new ShipOwnedByUserDTO();

            this.modelMapper.map(shipEntity, shipOwnedByUserDTO);

            allShipsOwnedByTheUser.add(shipOwnedByUserDTO);
        });

        return allShipsOwnedByTheUser;
    }

    @Override
    public Set<ShipOwnedNotByUserDTO> findAllShipsNotOwnedByTheUser() {
        Set<ShipOwnedNotByUserDTO> allShipsNotOwnerByTheUser = new HashSet<>();

        this.shipRepository.findByOwner_IdNot(this.loggedUser.getId()).forEach(shipEntity -> {
            ShipOwnedNotByUserDTO shipOwnedNotByUserDTO = new ShipOwnedNotByUserDTO();

            this.modelMapper.map(shipEntity, shipOwnedNotByUserDTO);

            allShipsNotOwnerByTheUser.add(shipOwnedNotByUserDTO);
        });

        return allShipsNotOwnerByTheUser;
    }

    @Override
    public void battle(ShipsForBattleDTO shipsForBattleDTO) {
        ShipEntity attacker = this.shipRepository.findByName(shipsForBattleDTO.getAttackerShipName());

        ShipEntity defender = this.shipRepository.findByName(shipsForBattleDTO.getDefenderShipName());

        defender.setHealth(defender.getHealth() - attacker.getPower());

        if (defender.getHealth() <= 0) {
            this.shipRepository.deleteById(defender.getId());
        }
    }
}
