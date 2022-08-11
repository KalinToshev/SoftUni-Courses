package CounterStriker.models.guns;

public class Rifle extends GunImpl {
    private static final int FIRE_BULLET = 10;

    public Rifle(String name, int bulletsCount) {
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
