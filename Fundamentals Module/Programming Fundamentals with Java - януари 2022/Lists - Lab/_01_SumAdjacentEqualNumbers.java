package bg.softuni.ListsLab;
import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class _01_SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> numbers = Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Double::parseDouble).collect(Collectors.toList());

        List<Double> nextNumbers = sumAdjecentNumbers(numbers);
        while (nextNumbers.size() != numbers.size()) {
            numbers = nextNumbers;
            nextNumbers = sumAdjecentNumbers(numbers);
        }

        for (double number : numbers) {
            DecimalFormat decimalFormat = new DecimalFormat("0.###");
            String formattedNum = decimalFormat.format(number);
            System.out.print(formattedNum + " ");
        }
    }

    private static List<Double> sumAdjecentNumbers(List<Double> numbers) {
        List<Double> nextNumbers = new ArrayList<>();
        int i = 0;
        while (i < numbers.size()) {
            if (i < numbers.size() - 1 && Objects.equals(numbers.get(i), numbers.get(i + 1))) {
                nextNumbers.add(numbers.get(i) + numbers.get(i + 1));
                i += 2;
            } else {
                nextNumbers.add(numbers.get(i));
                i++;
            }
        }
        return nextNumbers;
    }
}
