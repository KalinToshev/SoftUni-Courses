package viceCity.repositories.interfaces;

import viceCity.models.guns.Gun;

import java.util.ArrayDeque;
import java.util.Collection;

public class GunRepository implements Repository<Gun> {
    private ArrayDeque<Gun> models;

    public GunRepository() {
        this.models = new ArrayDeque<>();
    }

    @Override
    public ArrayDeque<Gun> getModels() {
        return models;
    }

    @Override
    public void add(Gun model) {
        if(!models.contains(model)) {
            models.offer(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        return models.remove(model);
    }

    @Override
    public Gun find(String name) {
        return models.stream()
                .filter(s -> s.getName().equals(name))
                .findAny()
                .get();
    }
}
