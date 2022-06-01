import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> returnMinNumber = list -> list.stream().min(Integer::compare).get();

        int minNumber = returnMinNumber.apply(integers);

        System.out.println(integers.lastIndexOf(minNumber));
    }
}
