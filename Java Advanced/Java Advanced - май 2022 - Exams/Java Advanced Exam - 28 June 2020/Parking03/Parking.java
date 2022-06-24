package JavaAdvancedExam28June2020.Parking03;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Car> data;
    private String type;
    private int capacity;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        Car carToRemove = this.data.stream().filter(car -> car.getManufacturer().equals(manufacturer)).findFirst().orElse(null);
        if (carToRemove != null) {
            if (carToRemove.getModel().equals(model)) {
                this.data.remove(carToRemove);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car oldestCar = null;
        int oldest = Integer.MIN_VALUE;
        for (Car car : this.data) {
            if (car.getYear() > oldest) {
                oldest = car.getYear();
            }
        }
        int finalOldest = oldest;
        oldestCar = this.data.stream().filter(car -> car.getYear() == finalOldest).findFirst().orElse(null);
        return oldestCar;
    }

    public Car getCar(String manufacturer, String model)  {
        Car carToGet = this.data.stream().filter(car -> car.getManufacturer().equals(manufacturer)).findFirst().orElse(null);
        if (carToGet != null) {
            if (carToGet.getModel().equals(model)) {
                return carToGet;
            }
        }
        return carToGet;
    }

    public int getCount() {
        return this.data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The cars are parked in ").append(getType()).append(":").append(System.lineSeparator());
        for (Car car : this.data) {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
