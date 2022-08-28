package football.entities.player;

public class Men extends BasePlayer {
    private static final double KG = 85.50;
    private static final int STRENGTH_INCREASE = 145;

    public Men(String name, String nationality, int strength) {
        super(name, nationality, strength);
        setKg(KG);
    }

    @Override
    public void stimulation() {
        setStrength(getStrength() + STRENGTH_INCREASE);
    }
}
