import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String command;
        while (!"end".equals(command = scanner.nextLine())) {
            switch (command) {
                case "add":
                    //add 1
                    numbers = numbers.stream().map(e -> e + 1).collect(Collectors.toList());
                    break;
                case "multiply":
                    //multiply 2
                    numbers = numbers.stream().map(e -> e * 2).collect(Collectors.toList());
                    break;
                case "subtract":
                    //subtract 1
                    numbers = numbers.stream().map(e -> e - 1).collect(Collectors.toList());
                    break;
                case "print":
                    //print all elements
                    System.out.println(numbers.stream().map(String::valueOf).collect(Collectors.joining(" ")));
                    break;
            }
        }
    }
}
