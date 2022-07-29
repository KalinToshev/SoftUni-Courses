package garage;

import org.junit.Assert;
import org.junit.Test;

public class GarageTests {
    //TODO: Test Garage class
    @Test
    public void testGetCountMethod() {
        Car car = new Car("test", 100, 100);
        Garage garage = new Garage();
        garage.addCar(car);
        Assert.assertEquals(1, garage.getCount());
    }

    @Test
    public void testfindAllCarsWithMaxSpeedAboveMethod() {
        Car car1 = new Car("test1", 100, 100);
        Car car2 = new Car("test2", 160, 100);
        Car car3 = new Car("test3", 170, 100);

        Garage garage = new Garage();
        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);

        Assert.assertEquals(2, garage.findAllCarsWithMaxSpeedAbove(150).size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddCarShouldThrowException() {
        Car car = null;
        Garage garage = new Garage();
        garage.addCar(car);
    }

    @Test
    public void testAddCarMethodShouldAddCarToTheGarageRepo() {
        Car car = new Car("test", 100, 100);
        Garage garage = new Garage();
        garage.addCar(car);
        Assert.assertEquals(1, garage.getCount());
    }

    @Test
    public void testgetTheMostExpensiveCarMethod() {
        Car car1 = new Car("test1", 100, 150);
        Car car2 = new Car("test2", 150, 200);

        Garage garage = new Garage();

        garage.addCar(car1);
        garage.addCar(car2);

        Assert.assertEquals(200, garage.getTheMostExpensiveCar().getPrice(), 0.0);
    }

    @Test
    public void testFindAllCarsByBrandMethod() {
        Car car1 = new Car("Mercedes-Benz", 100, 100);
        Car car2 = new Car("Mercedes-Benz", 160, 100);
        Car car3 = new Car("BMW", 170, 100);

        Garage garage = new Garage();

        garage.addCar(car1);
        garage.addCar(car2);
        garage.addCar(car3);

        Assert.assertEquals(2, garage.findAllCarsByBrand("Mercedes-Benz").size());
    }


}