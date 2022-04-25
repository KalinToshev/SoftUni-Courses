package bg.softuni.ListExercise;

import java.util.*;
import java.util.stream.Collectors;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> miniArrays = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());

        List<String> manipulateArray = new ArrayList<>();

        for (String miniArray : miniArrays) {
            String[] data = miniArray.split("\\s+");
            for (int i = data.length - 1;  i >= 0; i--) {
                manipulateArray.add(0, data[i]);
            }
        }

        for (int i = 0; i < manipulateArray.size(); i++) {
            manipulateArray.remove("");
        }

        manipulateArray.forEach(v -> System.out.print(v + " "));
    }
}
