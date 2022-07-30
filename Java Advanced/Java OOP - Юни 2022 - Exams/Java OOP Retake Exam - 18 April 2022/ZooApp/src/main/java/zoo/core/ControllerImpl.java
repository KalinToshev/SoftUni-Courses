package zoo.core;

import zoo.common.ConstantMessages;
import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.animals.AquaticAnimal;
import zoo.entities.animals.TerrestrialAnimal;
import zoo.entities.areas.Area;
import zoo.entities.areas.LandArea;
import zoo.entities.areas.WaterArea;
import zoo.entities.foods.Food;
import zoo.entities.foods.Meat;
import zoo.entities.foods.Vegetable;
import zoo.repositories.FoodRepositoryImpl;

import java.util.ArrayList;
import java.util.Collection;

public class ControllerImpl implements Controller {
    private final FoodRepositoryImpl foodRepository;
    private final Collection<Area> areas;

    public ControllerImpl() {
        this.foodRepository = new FoodRepositoryImpl();
        this.areas = new ArrayList<>();
    }

    @Override
    public String addArea(String areaType, String areaName) {
        if (!(areaType.equals("LandArea") || areaType.equals("WaterArea"))) {
            throw new NullPointerException(ExceptionMessages.INVALID_AREA_TYPE);
        }

        Area area;
        switch (areaType) {
            case "LandArea":
                area = new LandArea(areaName);
                areas.add(area);
                break;
            case "WaterArea":
                area = new WaterArea(areaName);
                areas.add(area);
                break;

        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_AREA_TYPE, areaType);
    }

    @Override
    public String buyFood(String type) {
        if (!(type.equals("Meat") || type.equals("Vegetable"))) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_FOOD_TYPE);
        }
        Food food;
        switch (type) {
            case "Meat":
                food = new Meat();
                foodRepository.add(food);
                break;
            case "Vegetable":
                food = new Vegetable();
                foodRepository.add(food);
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_TYPE, type);
    }

    @Override
    public String foodForArea(String areaName, String foodType) {
        Area area = getAreaByName(areaName);
        Food food = foodRepository.findByType(foodType);
        if (food == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_FOOD_FOUND,foodType));
        }
        area.addFood(food);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_FOOD_IN_AREA,foodType , areaName);
    }

    @Override
    public String addAnimal(String areaName, String animalType, String animalName, String kind, double price) {
        Area area = getAreaByName(areaName);
        Animal animal;
        switch (animalType) {
            case "AquaticAnimal":
                animal = new AquaticAnimal(animalName, kind, price);
                break;
            case "TerrestrialAnimal":
                animal = new TerrestrialAnimal(animalName, kind, price);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.INVALID_ANIMAL_TYPE);
        }
        if (area.getClass().getSimpleName().equals("WaterArea") && animalType.equals("AquaticAnimal")) {
            area.addAnimal(animal);
        } else if (area.getClass().getSimpleName().equals("LandArea") && animalType.equals("TerrestrialAnimal")) {
            area.addAnimal(animal);
        } else {
            return ConstantMessages.AREA_NOT_SUITABLE;
        }
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_ANIMAL_IN_AREA, animalType, areaName);
    }

    @Override
    public String feedAnimal(String areaName) {
        Area area = getAreaByName(areaName);
        for (Animal a : area.getAnimal()) {
            a.eat();
        }
        return String.format(ConstantMessages.ANIMALS_FED, area.getAnimal().size());
    }

    @Override
    public String calculateKg(String areaName) {
        Area area = getAreaByName(areaName);
        double sumKg = 0;
        for (Animal a : area.getAnimal()) {
            sumKg += a.getKg();
        }

        return String.format(ConstantMessages.KILOGRAMS_AREA, areaName, sumKg);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb=new StringBuilder();
        for (Area area : this.areas) {
            sb.append(area.getInfo());
            sb.append(System.lineSeparator());
        }
        return sb.toString().trim();

    }

    private Area getAreaByName(String areaName) {
        return areas.stream()
                .filter(a -> a.getName().equals(areaName))
                .findFirst()
                .orElse(null);
    }
}
