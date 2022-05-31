import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Integer[], Integer> findMinNum = intArray -> Arrays.stream(intArray).sorted().findFirst().orElse(0);

        System.out.println(findMinNum.apply(Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toArray(Integer[]::new)));
    }
}
