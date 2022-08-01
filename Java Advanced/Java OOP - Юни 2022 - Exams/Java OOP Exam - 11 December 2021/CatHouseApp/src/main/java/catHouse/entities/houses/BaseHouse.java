package catHouse.entities.houses;

import catHouse.entities.cat.Cat;
import catHouse.entities.toys.Toy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

import static catHouse.common.ExceptionMessages.*;
import static catHouse.common.ConstantMessages.*;

public abstract class BaseHouse implements House {
    private String name;
    private final int capacity;
    private final Collection<Toy> toys;
    private final Collection<Cat> cats;

    public BaseHouse(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.toys = new ArrayList<>();
        this.cats = new ArrayList<>();
    }

    @Override
    public int sumSoftness() {
        return toys.stream().mapToInt(Toy::getSoftness).sum();
    }

    @Override
    public void addCat(Cat cat) {
        if (this.cats.size() == this.capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY_FOR_CAT);
        }
        this.cats.add(cat);
    }

    @Override
    public void removeCat(Cat cat) {
        this.cats.remove(cat);
    }

    @Override
    public void buyToy(Toy toy) {
        this.toys.add(toy);
    }

    @Override
    public void feeding() {
        cats.forEach(Cat::eating);
    }

    @Override
    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.
                append(String.format("%s %s:", this.getName(), this.getClass().getSimpleName())).
                append(System.lineSeparator());

        if (this.cats.isEmpty()) {
            stringBuilder.
                    append("Cats: none").
                    append(System.lineSeparator());
        } else {
            stringBuilder.append("Cats: ").
                    append(this.cats.stream().map(Cat::getName).collect(Collectors.joining(" "))).
                    append(System.lineSeparator());
        }

            stringBuilder.append("Toys: ").
                    append(this.toys.size()).
                    append(" Softness: ").
                    append(sumSoftness()).
                    append(System.lineSeparator());

        return stringBuilder.toString().trim();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(HOUSE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Cat> getCats() {
        return Collections.unmodifiableCollection(this.cats);
    }

    @Override
    public Collection<Toy> getToys() {
        return Collections.unmodifiableCollection(this.toys);
    }

    @Override
    public int getCapacity() {
        return capacity;
    }
}
