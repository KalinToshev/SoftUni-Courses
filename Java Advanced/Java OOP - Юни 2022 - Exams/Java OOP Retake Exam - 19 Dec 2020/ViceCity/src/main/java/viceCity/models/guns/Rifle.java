package viceCity.models.guns;

public class Rifle extends BaseGun {
    public static final int BULLETS_PER_BARREL = 50;
    public static final int TOTAL_BULLETS = 500;
    public static final int PISTOL_BULLETS_PER_SHOOT = 5;

    public Rifle(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
        setBulletsPerShoot(PISTOL_BULLETS_PER_SHOOT);
    }
}
