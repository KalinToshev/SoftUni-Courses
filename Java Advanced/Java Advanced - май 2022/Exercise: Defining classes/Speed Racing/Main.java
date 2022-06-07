import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Car> cars = new LinkedHashMap<>();

        int numberOfCarsToTrack = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCarsToTrack; i++) {
            //"{Model} {FuelAmount} {FuelCostFor1km}"
            String[] inputData = scanner.nextLine().split("\\s+");
            String model = inputData[0];
            double fuelAmount = Double.parseDouble(inputData[1]);
            double fuelCostFor1km = Double.parseDouble(inputData[2]);

            if (!cars.containsKey(model)) {
                Car car = new Car(model, fuelAmount, fuelCostFor1km);
                cars.put(model, car);
            }
        }

        String command;
        while (!"End".equals(command = scanner.nextLine())) {
            String[] data = command.split("\\s+");
            String model = data[1];
            double amountOfKm = Double.parseDouble(data[2]);

            //Изчисляваме колко км може да мине дадената кола
            if (cars.containsKey(model)) {
                double fuelCostForTheTravel = cars.get(model).getFuelCostFor1Kilometer() * amountOfKm;
                if (fuelCostForTheTravel <= cars.get(model).getFuelAmount()) {
                    cars.get(model).setFuelAmount(cars.get(model).getFuelAmount() - fuelCostForTheTravel);
                    cars.get(model).setDistanceTraveled(cars.get(model).getDistanceTraveled() + amountOfKm);
                } else {
                    System.out.println("Insufficient fuel for the drive");
                }
            }
        }

        cars.forEach((k, v) -> {
            System.out.println(v.toString());
        });
    }
}
