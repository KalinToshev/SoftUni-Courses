package fairyShop.repositories;

import fairyShop.models.Helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HelperRepository implements Repository<Helper> {
    //A collection of helpers
    private Collection<Helper> helpers;

    public HelperRepository() {
        this.helpers = new ArrayList<>();
    }

    //Returns a collection of helpers(unmodifiable).
    @Override
    public Collection<Helper> getModels() {
        return Collections.unmodifiableCollection(this.helpers);
    }

    //Adds a helper to the collection.
    @Override
    public void add(Helper helper) {
        this.helpers.add(helper);
    }

    //Removes a helper from the collection.
    @Override
    public boolean remove(Helper helper) {
        return this.helpers.remove(helper);
    }

    //Returns a helper with that name if such exists.
    @Override
    public Helper findByName(String name) {
        for (Helper helper : this.helpers) {
            if(helper.getName().equals(name)){
                return helper;
            }
        }
        return null;
    }
}
