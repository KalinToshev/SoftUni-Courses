package spaceStation.models.astronauts;

public class Geodesist extends BaseAstronaut {
    private final static int INITIAL_UNITS_OF_OXYGEN = 50;

    public Geodesist(String name) {
        super(name, INITIAL_UNITS_OF_OXYGEN);
    }
}
