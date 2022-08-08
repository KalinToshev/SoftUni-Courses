package aquarium.entities.decorations;

public class Plant extends BaseDecoration {
    public final static int PLANT_COMFORT = 5;
    public final static double PLANT_PRICE = 10;

    public Plant() {
        super(PLANT_COMFORT, PLANT_PRICE);
    }
}
