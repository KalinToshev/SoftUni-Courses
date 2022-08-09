package viceCity.repositories.interfaces;

import java.util.ArrayDeque;

public interface Repository<T> {
    ArrayDeque<T> getModels();

    void add(T model);

    boolean remove(T model);

    T find(String name);
}
