package PolymorphismExercise.VehiclesExtension;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Creates a car
        String[] tokens = scanner.nextLine().split("\\s+");
        Vehicle car = createVehicle(tokens);

        //Creates a vehicle
        tokens = scanner.nextLine().split("\\s+");
        Vehicle truck = createVehicle(tokens);

        //Creates a bus
        tokens = scanner.nextLine().split("\\s+");
        Vehicle bus = createVehicle(tokens);

        //Adds vehicle to single data structure
        Map<String, Vehicle> vehicles = new LinkedHashMap<>();
        vehicles.put("PolymorphismExercise.VehiclesExtension.Car", car);
        vehicles.put("PolymorphismExercise.VehiclesExtension.Truck", truck);
        vehicles.put("PolymorphismExercise.VehiclesExtension.Bus", bus);

        int n = Integer.parseInt(scanner.nextLine());

        //execute commands
        for (int i = 0; i < n; i++) {
            tokens = scanner.nextLine().split("\\s+");
            String commandName = tokens[0];
            String vehicleType = tokens[1];

            switch (commandName){
                case "Drive":
                    double distance = Double.parseDouble(tokens[2]);
                    String driveMessage = vehicles.get(vehicleType).drive(commandName, distance);
                    System.out.println(driveMessage);
                    break;
                case "Refuel":
                    double fuelAmount = Double.parseDouble(tokens[2]);
                    vehicles.get(vehicleType).refuel(fuelAmount);
                    break;
                case "DriveEmpty":
                    distance = Double.parseDouble(tokens[2]);
                    driveMessage = vehicles.get(vehicleType).drive(commandName, distance);
                    System.out.println(driveMessage);
                    break;
            }
        }

        vehicles.values().forEach(System.out::println);
    }

    private static Vehicle createVehicle(String[] tokens) {
        String vehicleType = tokens[0];
        double fuelQuantity = Double.parseDouble(tokens[1]);
        double fuelConsumption = Double.parseDouble(tokens[2]);
        double tankCapacity = Double.parseDouble(tokens[3]);

        Vehicle vehicle = null;
        switch (vehicleType){
            case "PolymorphismExercise.VehiclesExtension.Car":
                vehicle =  new Car(fuelQuantity, fuelConsumption, tankCapacity);
                break;
            case "PolymorphismExercise.VehiclesExtension.Truck":
                vehicle =  new Truck(fuelQuantity, fuelConsumption, tankCapacity);
                break;
            case "PolymorphismExercise.VehiclesExtension.Bus":
                vehicle = new Bus(fuelQuantity, fuelConsumption, tankCapacity);
                break;
        }
        return vehicle;
    }
}
