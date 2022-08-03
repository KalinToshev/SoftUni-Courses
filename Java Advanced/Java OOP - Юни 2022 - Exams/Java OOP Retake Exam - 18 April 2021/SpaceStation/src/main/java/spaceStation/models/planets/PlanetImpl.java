package spaceStation.models.planets;

import static spaceStation.common.ExceptionMessages.*;

import java.util.ArrayList;
import java.util.Collection;

public class PlanetImpl implements Planet {
    private String name; //Name of the planet
    private Collection<String> items; //Collection of items, that can be found on the planet surface

    public PlanetImpl(String name) {
        setName(name);
        this.items = new ArrayList<>();
    }

    protected void setName(String name) {
        //If the name is null or whitespace, throw a NullPointerException with the message:
        //"Invalid name!"
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(PLANET_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    protected void setItems(Collection<String> items) {
        this.items = items;
    }

    @Override
    public Collection<String> getItems() {
        return items;
    }

    @Override
    public String getName() {
        return name;
    }
}
