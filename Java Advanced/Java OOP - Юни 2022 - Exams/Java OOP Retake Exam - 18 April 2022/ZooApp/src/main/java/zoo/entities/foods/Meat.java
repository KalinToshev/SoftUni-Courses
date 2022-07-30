package zoo.entities.foods;

public class Meat extends BaseFood{
    private final static int MEAT_CALORIES = 70;
    private final static double MEAT_PRICE = 10;

    public Meat() {
        super(MEAT_CALORIES, MEAT_PRICE);
    }
}
