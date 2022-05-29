import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split("\\s+");

        if (line.length <= 3) {
            System.out.println(String.join(" ", line));
        } else {
            List<Integer> numbers = Arrays.stream(line).map(Integer::parseInt)
                    .sorted((e1, e2) -> e2.compareTo(e1))
                    .collect(Collectors.toList());

            Collections.sort(numbers);
            Collections.reverse(numbers);

            for (int i = 0; i < 3; i++) {
                System.out.printf("%d ", numbers.get(i));
            }
        }
    }
}
