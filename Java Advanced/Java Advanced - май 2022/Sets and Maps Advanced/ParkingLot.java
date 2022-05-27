import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> cars = new LinkedHashSet<>();

        String input;
        while (!"END".equals(input = scanner.nextLine())) {
            String[] splitInput = input.split(", ");
            String direction = splitInput[0];
            String carNumber = splitInput[1];

            addOrRemoveCar(cars, direction, carNumber);

        }

        outputCars(cars);
    }

    private static void outputCars(Set<String> cars) {
        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : cars) {
                System.out.println(car);
            }
        }
    }

    private static void addOrRemoveCar(Set<String> cars, String direction, String carNumber) {
        if (direction.equals("IN")) {
            cars.add(carNumber);
        } else {
            cars.remove(carNumber);
        }
    }
}
