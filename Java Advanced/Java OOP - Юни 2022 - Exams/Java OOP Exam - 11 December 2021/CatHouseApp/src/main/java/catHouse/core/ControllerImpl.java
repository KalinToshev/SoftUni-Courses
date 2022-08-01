package catHouse.core;

import catHouse.entities.cat.Cat;
import catHouse.entities.cat.LonghairCat;
import catHouse.entities.cat.ShorthairCat;
import catHouse.entities.houses.House;
import catHouse.entities.houses.LongHouse;
import catHouse.entities.houses.ShortHouse;
import catHouse.entities.toys.Ball;
import catHouse.entities.toys.Mouse;
import catHouse.entities.toys.Toy;
import catHouse.repositories.ToyRepository;
import static catHouse.common.ConstantMessages.*;
import static catHouse.common.ExceptionMessages.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private final ToyRepository toyRepository;
    private final Collection<House> houses;

    public ControllerImpl() {
        this.toyRepository = new ToyRepository();
        this.houses = new ArrayList<>();
    }

    @Override
    public String addHouse(String type, String name) {
        House house;
        switch (type) {
            case "ShortHouse":
                house = new ShortHouse(name);
                break;
            case "LongHouse":
                house = new LongHouse(name);
                break;
            default:
                throw new NullPointerException(INVALID_HOUSE_TYPE);
        }

        this.houses.add(house);

        return String.format(SUCCESSFULLY_ADDED_HOUSE_TYPE, type);
    }

    @Override
    public String buyToy(String type) {
        Toy toy;
        switch (type) {
            case "Ball":
                toy = new Ball();
                break;
            case "Mouse":
                toy = new Mouse();
                break;
            default:
                throw new IllegalArgumentException(INVALID_TOY_TYPE);
        }

        toyRepository.buyToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_TYPE, type);
    }

    @Override
    public String toyForHouse(String houseName, String toyType) {
        Toy toy = this.toyRepository.findFirst(toyType);

        if (toy == null) {
            throw new IllegalArgumentException(String.format(NO_TOY_FOUND, toyType));
        }

        House house = getHouse(houseName);
        house.buyToy(toy);
        toyRepository.removeToy(toy);

        return String.format(SUCCESSFULLY_ADDED_TOY_IN_HOUSE, toyType, houseName);
    }

    @Override
    public String addCat(String houseName, String catType, String catName, String catBreed, double price) {
        Cat cat;
        switch (catType) {
            case "ShorthairCat":
                cat = new ShorthairCat(catName, catBreed, price);
                break;
            case "LonghairCat":
                cat = new LonghairCat(catName, catBreed, price);
                break;
            default:
                throw new IllegalArgumentException(INVALID_CAT_TYPE);
        }

        House house = getHouse(houseName);

        if((house.getClass().getSimpleName().equals("ShortHouse") && catType.equals("LonghairCat")) ||
                (house.getClass().getSimpleName().equals("LongHouse") && catType.equals("ShorthairCat"))) {
            return UNSUITABLE_HOUSE;
        }

        house.addCat(cat);

        return String.format(SUCCESSFULLY_ADDED_CAT_IN_HOUSE, catType, houseName);
    }

    @Override
    public String feedingCat(String houseName) {
        House house = getHouse(houseName);

        assert house != null;
        house.feeding();

        return String.format(FEEDING_CAT, house.getCats().size());
    }

    @Override
    public String sumOfAll(String houseName) {
        House house = getHouse(houseName);

        double allCatPrice = house.getCats().stream().mapToDouble(Cat::getPrice).sum();
        double allToyPrice = house.getToys().stream().mapToDouble(Toy::getPrice).sum();
        double value = allCatPrice + allToyPrice;

        return String.format(VALUE_HOUSE, houseName, value);
    }

    private House getHouse(String houseName) {
        return this.houses.stream()
                .filter(house1 -> house1.getName().equals(houseName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String getStatistics() {
        return houses.stream().map(House::getStatistics).collect(Collectors.joining(System.lineSeparator()));
    }
}
