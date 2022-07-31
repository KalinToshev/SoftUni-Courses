package fairyShop.repositories;

import fairyShop.models.Present;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class PresentRepository implements Repository<Present> {
    //A collection of presents.
    private Collection<Present> presents;

    public PresentRepository() {
        this.presents = new ArrayList<>();
    }

    //Returns a collection of helpers(unmodifiable).
    @Override
    public Collection<Present> getModels() {
        return Collections.unmodifiableCollection(this.presents);
    }

    //Adds a present to the collection.
    @Override
    public void add(Present present) {
        this.presents.add(present);
    }

    //Removes a present from the collection.
    @Override
    public boolean remove(Present present) {
        return this.presents.remove(present);
    }

    //Returns a helper with that name if such exists.
    @Override
    public Present findByName(String name) {
        for (Present present : this.presents) {
            if(present.getName().equals(name)){
                return present;
            }
        }
        return null;
    }
}
