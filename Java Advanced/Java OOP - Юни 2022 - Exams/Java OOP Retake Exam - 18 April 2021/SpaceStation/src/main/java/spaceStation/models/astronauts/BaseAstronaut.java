package spaceStation.models.astronauts;

import static spaceStation.common.ExceptionMessages.*;

import spaceStation.models.bags.Backpack;
import spaceStation.models.bags.Bag;

import java.util.Collections;
import java.util.stream.Collectors;

public abstract class BaseAstronaut implements Astronaut {
    private final static int OXYGEN_DECREASE_UNITS = 10;

    private String name; //The name of the astronaut
    private double oxygen; //The oxygen of the astronaut
    private Bag bag; //A field of type Backpack (astronaut backpack)

    public BaseAstronaut(String name, double oxygen) {
        setName(name);
        setOxygen(oxygen);
        this.bag = new Backpack();
    }

    protected void setName(String name) {
        //If the name is null or whitespace,throw a NullPointerException with a message:
        //"Astronaut name cannot be null or empty."
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ASTRONAUT_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setOxygen(double oxygen) {
        //If the oxygen is below 0, throw an IllegalArgumentException with a message:
        //"Cannot create Astronaut with negative oxygen!"
        if (oxygen < 0) {
            throw new IllegalArgumentException(ASTRONAUT_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    private void setBag(Bag bag) {
        this.bag = bag;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getOxygen() {
        return oxygen;
    }

    @Override
    public boolean canBreath() {
        return oxygen > 0;
    }

    @Override
    public Bag getBag() {
        return bag;
    }

    @Override
    public void breath() {
        //The method decreases the astronauts' oxygen by 10 units.
        //Keep in mind that some types of Astronaut can implement the method differently.
        //Astronaut's oxygen should not drop below zero.
        setOxygen(getOxygen() - (getOxygen() >= OXYGEN_DECREASE_UNITS ? OXYGEN_DECREASE_UNITS : 0));
    }

    @Override
    public String toString() {
        return "Name: " + getName() + System.lineSeparator() +
                "Oxygen: " + getOxygen() + System.lineSeparator() +
                "Bag items: " + (getBag().getItems().isEmpty() ? "none" : String.join(", ", getBag().getItems()));
    }
}
