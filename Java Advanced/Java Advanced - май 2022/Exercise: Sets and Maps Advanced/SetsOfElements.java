import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] lengthOfTwoSets = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Set<Integer> N = new LinkedHashSet<>();
        Set<Integer> M = new LinkedHashSet<>();

        for (int i = 0; i < lengthOfTwoSets[0]; i++) {
            N.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 0; i < lengthOfTwoSets[1]; i++) {
            M.add(Integer.parseInt(scanner.nextLine()));
        }

        N.retainAll(M);

        N.forEach(e -> System.out.print(e + " "));

    }
}
