package JavaAdvancedExam20February2021.Dealership03;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private List<Car> data;
    private String name;
    private int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < capacity) {
            data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        Car carToBuy = data.stream().filter(car -> car.getManufacturer().equals(manufacturer)).findFirst().orElse(null);
        if (carToBuy != null) {
            if (carToBuy.getModel().equals(model)) {
                data.remove(carToBuy);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car latestCar = null;
        int latest = Integer.MIN_VALUE;
        for (Car car : data) {
            if (car.getYear() > latest) {
                latest = car.getYear();
            }
        }
        int finalLatest = latest;
        latestCar = data.stream().filter(car -> car.getYear() == finalLatest).findFirst().orElse(null);
        return latestCar;
    }

    public Car getCar(String manufacturer, String model) {
        Car carToReturn = data.stream().filter(car -> car.getManufacturer().equals(manufacturer)).findFirst().orElse(null);
        if (carToReturn != null) {
            if (carToReturn.getModel().equals(model)) {
                return carToReturn;
            }
        }
        return carToReturn;
    }

    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are in a car dealership ").append(getName()).append(":").append(System.lineSeparator());
        for (Car car : data) {
            sb.append(car).append(System.lineSeparator());
        }
        return sb.toString();
    }

    public List<Car> getData() {
        return data;
    }

    public void setData(List<Car> data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
