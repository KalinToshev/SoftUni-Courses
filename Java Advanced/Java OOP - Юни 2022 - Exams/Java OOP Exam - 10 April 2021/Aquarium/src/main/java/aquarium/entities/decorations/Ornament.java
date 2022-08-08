package aquarium.entities.decorations;

public class Ornament extends BaseDecoration {
    public final static int ORNAMENT_COMFORT = 1;
    public final static double ORNAMENT_PRICE = 5;

    public Ornament() {
        super(ORNAMENT_COMFORT, ORNAMENT_PRICE);
    }
}
