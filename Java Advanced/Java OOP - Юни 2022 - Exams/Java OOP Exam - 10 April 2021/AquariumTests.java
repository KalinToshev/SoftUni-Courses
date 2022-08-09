package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AquariumTests {
    private Aquarium aquarium;
    private Aquarium limitedAquarium;
    private Fish fishOne;
    private Fish fishTwo;
    private Fish fishThree;

    @Before
    public void setUp() {
        aquarium = new Aquarium("Златната рибка", 10);
        limitedAquarium = new Aquarium("Лимитиран аквариум", 2);
        fishOne = new Fish("Калин");
        fishTwo = new Fish("Веселин");
        fishThree = new Fish("Мартин");
        aquarium.add(fishOne);
        aquarium.add(fishTwo);
        aquarium.add(fishThree);
        limitedAquarium.add(fishOne);
        limitedAquarium.add(fishTwo);
    }

    @Test(expected = NullPointerException.class)
    public void createAnAquariumNamedNull() {
        Aquarium aquariumTest = new Aquarium(null, 10);
    }

    @Test
    public void returnTheNameOfTheAquarium() {
        Assert.assertTrue(aquarium.getName().equals("Златната рибка"));
    }

    @Test
    public void returnTheCapacityOfTheAquarium() {
        Assert.assertEquals(10 , aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createAquariumWithNegativeCapacity() {
        Aquarium aquariumTest = new Aquarium("Рандом Име", -5);
    }

    @Test
    public void returnTheNumberOfFishInTheAquarium() {
        Assert.assertEquals(3, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void exceededTheCapacityOfTheAquarium() {
        limitedAquarium.add(fishThree);
    }

    @Test
    public void successfullyAddedFishToTheAquarium() {
        aquarium.add(new Fish("Радо"));
        Assert.assertEquals(4, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeFishWithWrongName() {
        aquarium.remove("Елица");
    }

    @Test
    public void successfullyRemoveFish() {
        aquarium.remove("Калин");
        Assert.assertEquals(2, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void sellAFishWithTheWrongName() {
        aquarium.sellFish("Стели мой тати");
    }

    @Test
    public void successfullySellFish() {
        Assert.assertFalse(aquarium.sellFish("Калин").isAvailable());
    }
}

