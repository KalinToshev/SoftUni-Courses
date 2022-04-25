package bg.softuni.ListExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        String line = scanner.nextLine();
        while (!line.equals("end")) {
            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "Delete":
                    int element = Integer.parseInt(tokens[1]);
                    integers.removeAll(Collections.singleton(element));
                    break;
                case "Insert":
                    element = Integer.parseInt(tokens[1]);
                    int position = Integer.parseInt(tokens[2]);
                    integers.add(position, element);
                    break;
            }

            line  = scanner.nextLine();
        }

        integers.forEach(v -> System.out.print(v + " "));

    }
}
