package bg.softuni.MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> parking = new LinkedHashMap<>();

        int numOfCommands = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numOfCommands; i++) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+");
            switch (tokens[0]) {
                case "register":
                    String username = tokens[1];
                    String licensePlateNumber = tokens[2];
                    if (parking.containsKey(username)) {
                        System.out.printf("ERROR: already registered with plate number %s%n", licensePlateNumber);
                    } else {
                        parking.put(username, licensePlateNumber);
                        System.out.printf("%s registered %s successfully%n", username, licensePlateNumber);
                    }
                    break;
                case "unregister":
                    username = tokens[1];
                    if (!parking.containsKey(username)) {
                        System.out.printf("ERROR: user %s not found%n", username);
                    } else {
                        parking.remove(username);
                        System.out.printf("%s unregistered successfully%n", username);
                    }
                    break;
            }
        }
        parking.forEach((k, v) -> System.out.printf("%s => %s%n", k, v));
    }
}
