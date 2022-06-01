import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        //get even and odd numbers separated
        Function<List<Integer>, List<Integer>> even = list -> list.stream()
                .filter(e -> e % 2 == 0)
                .collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> odd = list -> list.stream()
                .filter(e -> e % 2 != 0)
                .collect(Collectors.toList());

        //fill two lists
        List<Integer> listOne = even.apply(input);
        List<Integer> listTwo = odd.apply(input);

        //sort lists
        List<String> finalList = new ArrayList<>(listOne.stream().sorted().map(String::valueOf).collect(Collectors.toList()));
        finalList.addAll(listTwo.stream().sorted().map(String::valueOf).collect(Collectors.toList()));

        //output
        System.out.println(finalList.stream().collect(Collectors.joining(" ")));
    }
}
