package bg.softuni.MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> statistics = new LinkedHashMap<>();

        String command = scanner.nextLine();

        int counter = 1;
        int iteration = 1;

        String resource = "";
        int quantity = 0;

        while (!command.equals("stop")) {
            if (counter % 2 == 1) {
                resource = command;
            } else {
                quantity = Integer.parseInt(command);
            }

            if (iteration == 2) {
                if (!statistics.containsKey(resource)) {
                    statistics.put(resource, quantity);
                } else {
                    statistics.put(resource, statistics.get(resource) + quantity);
                }
                iteration = 0;
            }

            iteration++;
            counter++;
            command = scanner.nextLine();
        }

        statistics.forEach((key, value) -> System.out.printf("%s -> %d%n", key, value));
    }
}
