package bg.softuni.ListExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfWagons = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int maxCapacityOfEachWagon = Integer.parseInt(scanner.nextLine());

        String line = scanner.nextLine();
        while (!line.equals("end")) {
            String[] tokens = line.split(" ");

            if (tokens[0].equals("Add")) {
                int passengers = Integer.parseInt(tokens[1]);
                listOfWagons.add(passengers);
            }

            if (tokens.length == 1) {
                int passengers = Integer.parseInt(tokens[0]);
                for (int i = 0; i < listOfWagons.size(); i++) {
                    if (listOfWagons.get(i) + passengers <= maxCapacityOfEachWagon) {
                        listOfWagons.set(i, listOfWagons.get(i) + passengers);
                        break;
                    }
                }
            }

            line = scanner.nextLine();
        }

        listOfWagons.forEach(v -> System.out.print(v + " "));
    }
}
