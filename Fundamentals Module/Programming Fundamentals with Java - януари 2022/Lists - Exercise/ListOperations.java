package bg.softuni.ListExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] tokens = line.split("\\s+");

            switch (tokens[0]) {
                case "Add":
                    int number = Integer.parseInt(tokens[1]);
                    numbers.add(number);
                    break;
                case "Insert":
                    number = Integer.parseInt(tokens[1]);
                    int index = Integer.parseInt(tokens[2]);
                    if (index >= numbers.size() || index < 0) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.add(index, number);
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(tokens[1]);
                    if (index >= numbers.size() || index < 0) {
                        System.out.println("Invalid index");
                    } else {
                        numbers.remove(index);
                    }
                    break;
                case "Shift":
                    switch (tokens[1]) {
                        case "left":
                            int count = Integer.parseInt(tokens[2]);
                            for (int i = 0; i < count; i++) {
                                numbers.add(numbers.get(0));
                                numbers.remove(0);
                            }
                            break;
                        case "right":
                            count = Integer.parseInt(tokens[2]);
                            for (int i = 0; i < count; i++) {
                                numbers.add(0, numbers.get(numbers.size() - 1));
                                numbers.remove(numbers.size() - 1);
                            }
                            break;
                    }
                    break;
            }

            line = scanner.nextLine();
        }
        numbers.forEach(v -> System.out.print(v + " "));
    }
}
