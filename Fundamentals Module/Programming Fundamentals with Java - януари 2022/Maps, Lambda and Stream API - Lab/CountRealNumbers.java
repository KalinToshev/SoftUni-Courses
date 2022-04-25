package bg.softuni.MapsLambdaAndStreamAPILab;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> listOfRealNumbers = Arrays.stream(scanner.nextLine().split(" "))
                .map(Double::parseDouble).collect(Collectors.toList());

        Map<Double, Integer> ascendingOrderWithNumberOfOccurrences = new TreeMap<>();

        for (Double number : listOfRealNumbers) {
            checkIfGivenKeyExistOrNot(ascendingOrderWithNumberOfOccurrences, number);
        }

        formatAndPrint(ascendingOrderWithNumberOfOccurrences);

    }

    private static void formatAndPrint(Map<Double, Integer> ascendingOrderWithNumberOfOccurrences) {
        for (Map.Entry<Double, Integer> entry : ascendingOrderWithNumberOfOccurrences.entrySet()) {
            DecimalFormat df = new DecimalFormat("#.#######");
            System.out.printf("%s -> %d%n", df.format(entry.getKey()), entry.getValue());
        }
    }

    private static void checkIfGivenKeyExistOrNot(Map<Double, Integer> ascendingOrderWithNumberOfOccurrences, Double number) {
        if (!ascendingOrderWithNumberOfOccurrences.containsKey(number)) {
            ascendingOrderWithNumberOfOccurrences.put(number, 1);
        } else {
            ascendingOrderWithNumberOfOccurrences.put(number,
                    ascendingOrderWithNumberOfOccurrences.get(number) + 1);
        }
    }
}
