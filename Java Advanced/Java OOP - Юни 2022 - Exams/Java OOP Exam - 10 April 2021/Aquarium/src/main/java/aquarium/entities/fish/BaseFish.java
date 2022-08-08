package aquarium.entities.fish;

import static aquarium.common.ExceptionMessages.*;

public abstract class BaseFish implements Fish {
    private String name; //име на рибата
    private String species; //вид
    private int size; //размер на рибата
    private double price; //цена на рибата

    public BaseFish(String name, String species, double price) {
        setName(name);
        setSpecies(species);
        setPrice(price);
    }

    void setSize(int size) {
        this.size = size;
    }

    private void setSpecies(String species) {
        if(species == null || species.trim().isEmpty()) {
            throw new NullPointerException(SPECIES_NAME_NULL_OR_EMPTY);
        }
        this.species = species;
    }

    private void setPrice(double price) {
        if(price <= 0) {
            throw new IllegalArgumentException(FISH_PRICE_BELOW_OR_EQUAL_ZERO);
        }
        this.price = price;
    }

    @Override
    public void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new NullPointerException(FISH_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public void eat() {
        size += 5;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
