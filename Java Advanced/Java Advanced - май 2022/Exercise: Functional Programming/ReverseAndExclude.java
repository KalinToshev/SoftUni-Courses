import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //read
        List<Integer> integerList = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //reverse
        Collections.reverse(integerList);

        //remove
        int n = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> removeIfDivisible = e -> e % n == 0;
        integerList.removeIf(removeIfDivisible);

        //output
        System.out.println(integerList.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
