package gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GiftFactoryTests {
    private Gift bear;
    private Gift anotherBear;
    private Gift fox;
    private Gift horse;
    private GiftFactory factory;

    @Before
    public void setup() {
        bear = new Gift("TeddyBear", 2.5);
        anotherBear = new Gift("TeddyBear", 2.6);
        factory = new GiftFactory();
        fox = new Gift("Fox", 3.2);
        horse = new Gift("Horse", 1.2);
    }

    @Test
    public void getCount() {
        factory.createGift(bear);
        Assert.assertTrue(factory.getCount() == 1);
    }

    @Test
    public void createGift() {
        factory.createGift(bear);
        Assert.assertTrue(factory.getCount() == 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createExistGift() {
        factory.createGift(bear);
        factory.createGift(anotherBear);
    }

    @Test
    public void removeGift() {
        factory.createGift(bear);
        factory.createGift(fox);

        Assert.assertTrue(factory.removeGift("Fox"));
    }

    @Test(expected = NullPointerException.class)
    public void removeGiftShouldThrowExceptionBecauseNullParameterIsGiven() {
        factory.createGift(bear);

        factory.removeGift(null);
    }

    @Test(expected = NullPointerException.class)
    public void removeGiftShouldThrowExceptionBecauseWhitespaceParameterIsGiven() {
        factory.createGift(bear);

        factory.removeGift("    ");
    }

    @Test
    public void getPresentWithLeastMagic() {
        factory.createGift(bear);
        factory.createGift(fox);
        factory.createGift(horse);

        Assert.assertTrue(factory.getPresentWithLeastMagic().getMagic() == 1.2);
    }

    @Test
    public void getPresent() {
        factory.createGift(bear);
        factory.createGift(fox);
        factory.createGift(horse);

        Assert.assertTrue(factory.getPresent("Horse").getMagic() == 1.2);
    }

    @Test
    public void getPresents() {
        factory.createGift(bear);
        factory.createGift(fox);
        factory.createGift(horse);

        Assert.assertEquals(3, factory.getPresents().size());
    }
}