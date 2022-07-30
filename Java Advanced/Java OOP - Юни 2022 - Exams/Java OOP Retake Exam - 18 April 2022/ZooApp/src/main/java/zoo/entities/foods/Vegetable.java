package zoo.entities.foods;

public class Vegetable extends BaseFood {
    private final static int VEGETABLE_CALORIES = 50;
    private final static double VEGETABLE_PRICE = 5;

    public Vegetable() {
        super(VEGETABLE_CALORIES, VEGETABLE_PRICE);
    }
}
