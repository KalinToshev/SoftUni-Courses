import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int countOfCars = Integer.parseInt(scanner.nextLine());
        while (countOfCars-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String carModel = tokens[0];

            int engineSpeed = Integer.parseInt(tokens[1]);
            int enginePower = Integer.parseInt(tokens[2]);
            Engine engine = new Engine(engineSpeed, enginePower);

            int cargoWeight = Integer.parseInt(tokens[3]);
            String cargoType = tokens[4];
            Cargo cargo = new Cargo(cargoWeight, cargoType);

            List<Tire> tires = new ArrayList<>();
            for (int i = 5; i < tokens.length; i += 2) {
                double tirePressure = Double.parseDouble(tokens[i]);
                int tireAge = Integer.parseInt(tokens[i + 1]);
                Tire tire = new Tire(tirePressure, tireAge);
                tires.add(tire);
            }

            Car car = new Car(carModel, engine, cargo, tires);
            cars.add(car);
        }
        String cargoType = scanner.nextLine();
        if (cargoType.equals("fragile")) {
            cars.stream()
                    .filter(car -> car.getCargo().getCargoType().equals("fragile"))
                    .filter(car -> car.getTires().stream().anyMatch(tire -> tire.getTirePressure() < 1))
                    .forEach(car -> System.out.println(car.getModel()));
        } else {
            cars.stream()
                    .filter(car -> car.getCargo().getCargoType().equals("flamable"))
                    .filter(car -> car.getEngine().getEnginePower() > 250)
                    .forEach(car -> System.out.println(car.getModel()));
        }
    }
}
