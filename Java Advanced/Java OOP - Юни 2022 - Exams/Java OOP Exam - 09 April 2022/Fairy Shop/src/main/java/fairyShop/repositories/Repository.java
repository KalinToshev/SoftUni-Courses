package fairyShop.repositories;

import java.util.Collection;

public interface Repository<T> {
    //Done
    Collection<T> getModels();

    //Done
    void add(T model);

    //Done
    boolean remove(T model);

    //Done
    T findByName(String name);
}
