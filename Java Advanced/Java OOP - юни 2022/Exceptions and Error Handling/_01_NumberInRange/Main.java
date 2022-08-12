package ExceptionsAndErrorHandlingLab.NumberInRange;

import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] range = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int beginRange = range[0];
        int endRange = range[1];

        System.out.println("Range: [" + beginRange + "..." + endRange + "]");

        String input = scanner.nextLine();

        boolean isInRange = false;

        while (!isInRange) {
            Optional<Integer> number = Optional.empty();
            try {
                number = Optional.of(Integer.parseInt(input));
            } catch (NumberFormatException ignored) {
            }
            if (number.isEmpty() || number.get() < beginRange || number.get() > endRange) {
                System.out.println("Invalid number: " + input);
                input = scanner.nextLine();
            } else {
                isInRange = true;
            }
        }
        System.out.println("Valid number: " + input);
    }
}
