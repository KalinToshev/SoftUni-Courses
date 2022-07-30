package zoo.entities.areas;

import zoo.common.ExceptionMessages;
import zoo.entities.animals.Animal;
import zoo.entities.foods.Food;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseArea implements Area {
    private String name;
    private final int capacity;
    private final Collection<Food> foods;
    private final Collection<Animal> animals;

    protected BaseArea(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.animals = new ArrayList<>();
        this.foods = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AREA_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int sumCalories() {
        int sum = 0;
        for (Food food : foods) {
            sum += food.getCalories();
        }
        return sum;
    }

    @Override
    public void addAnimal(Animal animal) {
        if (animal.getKg() >= capacity) {
            throw new IllegalStateException(ExceptionMessages.NOT_ENOUGH_CAPACITY);
        }
        this.animals.add(animal);
    }

    @Override
    public void removeAnimal(Animal animal) {
        this.animals.remove(animal);
    }

    @Override
    public void addFood(Food food) {
        this.foods.add(food);
    }

    @Override
    public void feed() {
        for (Animal a : this.animals) {
            a.eat();
        }
    }

    @Override
    public String getInfo() {
        return toString();
    }

    @Override
    public Collection<Animal> getAnimal() {
        return animals;
    }

    @Override
    public Collection<Food> getFood() {
        return foods;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder()
                .append(String.format("%s (%s):", this.name, this.getClass().getSimpleName()))
                .append(System.lineSeparator())
                .append("Animal: ");

        if (this.animals.isEmpty()) {
            output.append("none");
        } else {

            output.append(this.animals.stream().map(Animal::getName).collect(Collectors.joining(" ")));
        }

        output
                .append(System.lineSeparator())
                .append("Foods: ")
                .append(this.foods.size())
                .append(System.lineSeparator())
                .append("Calories: ")
                .append(this.sumCalories());

        return output.toString().trim();
    }
}
