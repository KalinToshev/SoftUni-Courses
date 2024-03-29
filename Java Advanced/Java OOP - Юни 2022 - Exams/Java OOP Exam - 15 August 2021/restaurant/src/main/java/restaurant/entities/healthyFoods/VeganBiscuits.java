package restaurant.entities.healthyFoods;

public class VeganBiscuits extends Food {
    private final static double INITIAL_VEGAN_BISCUITS_PORTION = 205;

    public VeganBiscuits(String name, double price) {
        super(name, INITIAL_VEGAN_BISCUITS_PORTION, price);
    }
}
