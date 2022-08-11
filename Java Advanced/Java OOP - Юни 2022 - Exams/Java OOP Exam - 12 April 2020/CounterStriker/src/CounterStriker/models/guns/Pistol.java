package CounterStriker.models.guns;

public class Pistol extends GunImpl {
    private static final int FIRE_BULLET = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (getBulletsCount() < FIRE_BULLET) {
            return 0;
        }
        setBulletsCount(getBulletsCount() - FIRE_BULLET);
        return FIRE_BULLET;
    }
}
