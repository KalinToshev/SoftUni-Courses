import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Predicate<String> validLength = e -> e.length() <= n;

        String[] data = scanner.nextLine().split("\\s+");

        List<String> newData = Arrays.stream(data).filter(validLength).collect(Collectors.toList());

        newData.forEach(System.out::println);
    }
}
