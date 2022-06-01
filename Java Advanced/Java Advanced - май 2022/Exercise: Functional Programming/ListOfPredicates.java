import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .toArray(Integer[]::new);

        Predicate<Integer> divisible = e -> Arrays.stream(numbers).allMatch(l -> e % l == 0);
        
        System.out.println(IntStream.range(1, n + 1)
                .boxed()
                .filter(divisible)
                .map(String::valueOf)
                .collect(Collectors.joining(" ")));
    }
}
