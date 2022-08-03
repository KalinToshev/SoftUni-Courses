package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private final static int INITIAL_UNITS_OF_OXYGEN = 70;
    private final static int OXYGEN_DECREASE_UNITS = 5;

    public Biologist(String name) {
        super(name, INITIAL_UNITS_OF_OXYGEN);
    }

    @Override
    public void breath() {
        setOxygen(getOxygen() - (getOxygen() >= OXYGEN_DECREASE_UNITS ? OXYGEN_DECREASE_UNITS : 0));
    }
}
