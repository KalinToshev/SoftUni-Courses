package farmville;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FarmvilleTests {
    private Farm farm;
    private Animal dog;
    private Animal cat;
    private Animal frog;

    @Test(expected = NullPointerException.class)
    public void createFarmWhitNullName(){
        Farm testFarm = new Farm(null, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createFarmWhitNegativeCapacity(){
        Farm testFarm = new Farm("Test Farm", -5);
    }

    @Before
    public void setUp() {
        farm = new Farm("Ferma-Doni", 10);
        dog = new Animal("Kuche", 10);
        cat = new Animal("Kotka", 20);
        frog = new Animal("Jaba", 5);
    }

    @Test
    public void getCount() {
        farm.add(dog);
        farm.add(cat);
        farm.add(frog);

        Assert.assertEquals(3, farm.getCount());
    }

    @Test
    public void getName() {
        Assert.assertTrue("Ferma-Doni".equals(farm.getName()));
    }

    @Test
    public void getCapacity() {
        Assert.assertEquals(10, farm.getCapacity());
    }

    @Test
    public void add() {
        farm.add(dog);
        Assert.assertEquals(1, farm.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodButWhenInsertTheSameAnimalShouldThrowException() {
        farm.add(dog);
        farm.add(dog);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodButTheCapacityIsFullAndAnotherAnimalIsAdded() {
        Farm otherFarm = new Farm("TestFarm", 2);
        otherFarm.add(dog);
        otherFarm.add(cat);
        otherFarm.add(frog);
    }

    @Test
    public void remove() {
        farm.add(dog);
        Assert.assertTrue(farm.remove("Kuche"));
    }

    @Test
    public void testRemoveMethodButNonExistingAnimalIsGiven() {
        farm.add(dog);
        Assert.assertFalse(farm.remove("Konq"));
    }
}

