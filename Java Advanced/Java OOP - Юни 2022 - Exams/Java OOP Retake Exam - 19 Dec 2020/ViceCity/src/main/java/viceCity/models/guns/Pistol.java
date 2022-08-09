package viceCity.models.guns;

public class Pistol extends BaseGun {
    public static final int BULLETS_PER_BARREL = 10;
    public static final int TOTAL_BULLETS = 100;
    public static final int PISTOL_BULLETS_PER_SHOOT = 1;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
        setBulletsPerShoot(PISTOL_BULLETS_PER_SHOOT);
    }
}
