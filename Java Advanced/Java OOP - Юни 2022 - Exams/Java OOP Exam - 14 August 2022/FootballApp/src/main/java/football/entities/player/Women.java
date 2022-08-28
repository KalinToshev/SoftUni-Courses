package football.entities.player;

public class Women extends BasePlayer {
    private static final double KG = 60.00;
    private static final int STRENGTH_INCREASE = 115;

    public Women(String name, String nationality, int strength) {
        super(name, nationality, strength);
        setKg(KG);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength() + STRENGTH_INCREASE);
    }
}
