package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTests {
    private Player player;
    private Gun gun;

    @Before
    public void setUp() {
        this.player = new Player("Калин", 100);
        this.gun = new Gun("Ak-47", 10);
        player.addGun(gun);
    }

    @Test
    public void test_getUsername_ShouldReturnThePlayerUsername() {
        Assert.assertEquals("Калин", player.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void test_setUsername_ShouldThrowExceptionBecauseNullNameIsGiven() {
        Player player = new Player(null, 100);
    }

    @Test(expected = NullPointerException.class)
    public void test_setUsername_ShouldThrowExceptionBecauseWhitespaceNameIsGiven() {
        Player player = new Player("        ", 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_setHealth_ShouldThrowExceptionBecauseNegativeNumberIsGiven() {
        Player player = new Player("Йордан", -5);
    }

    @Test
    public void test_getHealth_ShouldReturnTheHealthOfThePlayer() {
        Assert.assertEquals(100, player.getHealth());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void test_getGuns_ShouldThrowExceptionBecauseRemoveCommandIsTriedOnUnmodifiableList() {
        player.getGuns().remove(1);
    }

    @Test(expected = IllegalStateException.class)
    public void test_takeDamage_ShouldThrowExceptionBecauseTheHealthOfThePlayerIsLowOrEqualsToZero() {
        Player player = new Player("Йордан", 0);
        player.takeDamage(110);
    }

    @Test
    public void test_takeDamage_ShouldReturnZeroBecauseTheGivenDamageIsMoreThanTheHealthOfPlayer() {
        Player player = new Player("Ivan", 10);
        player.takeDamage(15);
        Assert.assertEquals(0, player.getHealth());
    }

    @Test
    public void test_takeDamage_ShouldReturnProperValue() {
        Player player = new Player("Ivan", 10);
        player.takeDamage(5);
        Assert.assertEquals(5, player.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void test_addGun_ShouldThrowExceptionBecauseTheGivenGunIsNull() {
        Player player = new Player("Ivan", 10);
        Gun gun = null;
        player.addGun(gun);
    }

    @Test
    public void test_addGun_EverythingShouldBeSuccessful() {
        Player player = new Player("Ivan", 10);
        player.addGun(gun);
        Assert.assertEquals(1, player.getGuns().size());
    }

    @Test
    public void test_removeGun_ShouldReturnTrue() {
        Player player = new Player("Ivan", 10);
        player.addGun(gun);
        Assert.assertTrue(player.removeGun(gun));
    }

    @Test
    public void test_removeGun_ShouldReturnFalse() {
        Player player = new Player("Ivan", 10);
        player.addGun(gun);
        Assert.assertFalse(player.removeGun(new Gun("Eagle", 12)));
    }

    @Test
    public void test_getGun_ShouldReturnNull() {
        Assert.assertTrue(player.getGun("Eagle") == null);
    }

    @Test
    public void test_getGun_ShouldReturnTheGun() {
        Assert.assertTrue(player.getGun("Ak-47") == gun);
    }
}

