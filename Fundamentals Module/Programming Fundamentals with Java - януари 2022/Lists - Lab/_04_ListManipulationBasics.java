package bg.softuni.ListsLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }

            String[] tokens = line.split(" ");

            switch (tokens[0]) {
                case "Add":
                    int number = Integer.parseInt(tokens[1]);
                    numbers.add(number);
                    break;
                case "Remove":
                    number = Integer.parseInt(tokens[1]);
                    numbers.remove(Integer.valueOf(number));
                    break;
                case "RemoveAt":
                    int index = Integer.parseInt(tokens[1]);
                    numbers.remove(index);
                    break;
                case "Insert":
                    number = Integer.parseInt(tokens[1]);
                    index = Integer.parseInt(tokens[2]);
                    numbers.add(index, number);
                    break;
            }
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
