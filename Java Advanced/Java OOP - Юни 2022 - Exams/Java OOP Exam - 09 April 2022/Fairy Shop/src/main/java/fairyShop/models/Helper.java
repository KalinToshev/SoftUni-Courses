package fairyShop.models;

import java.util.Collection;

public interface Helper {
    //Done
    void work();

    //Done
    void addInstrument(Instrument instrument);

    //Done
    boolean canWork();

    //Done
    String getName();

    //Done
    int getEnergy();

    //Done
    Collection<Instrument> getInstruments();
}
