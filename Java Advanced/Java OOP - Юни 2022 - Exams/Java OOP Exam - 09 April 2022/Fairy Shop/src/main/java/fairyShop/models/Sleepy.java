package fairyShop.models;

public class Sleepy extends BaseHelper {
    private static final int INITIAL_ENERGY_UNITS = 50;
    private static final int ADDITIONAL_ENERGY_DECREASER = 5;
    private static final int ENERGY_DECREASER = 10;

    public Sleepy(String name) {
        super(name, INITIAL_ENERGY_UNITS);
    }

    @Override
    public void work() {
        setEnergy(getEnergy() - 5);
        super.work();
    }
}
