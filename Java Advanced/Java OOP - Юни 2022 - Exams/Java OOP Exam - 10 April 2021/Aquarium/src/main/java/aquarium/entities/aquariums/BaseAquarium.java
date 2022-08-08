package aquarium.entities.aquariums;

import static aquarium.common.ExceptionMessages.*;

import static aquarium.common.ConstantMessages.*;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public abstract class BaseAquarium implements Aquarium {
    private String name; //име на аквариума
    private int capacity; //броя на рибитите, които могат да се съберат в акравиума
    private Collection<Decoration> decorations; //колекция от декорации
    private Collection<Fish> fish; //колекция от риби

    public BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int calculateComfort() {
        return decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addFish(Fish fishh) {
        if(this.fish.size() == capacity) {
            throw new IllegalStateException(NOT_ENOUGH_CAPACITY);
        }

        this.fish.add(fishh);
    }

    @Override
    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    @Override
    public void addDecoration(Decoration decoration) {
        decorations.add(decoration);
    }

    @Override
    public void feed() {
        fish.forEach(Fish::eat);
    }

    @Override
    public String getInfo() {
        return String.format(AQUARIUM_INFO, name, getClass().getSimpleName()) + System.lineSeparator() +
                String.format(FISH_INFO,
                        (fish.size() == 0 ?
                                "none" :
                                fish.stream().map(Fish::getName).collect(Collectors.joining(" ")))) + System.lineSeparator() +
                String.format(DECORATIONS_INFO, decorations.size()) + System.lineSeparator() +
                String.format(COMFORT_INFO, calculateComfort());
    }

    @Override
    public Collection<Fish> getFish() {
        return fish;
    }

    @Override
    public Collection<Decoration> getDecorations() {
        return decorations;
    }
}
