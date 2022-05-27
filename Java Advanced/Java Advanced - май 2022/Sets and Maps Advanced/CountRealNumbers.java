import java.util.*;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> values = new ArrayList<>(Arrays.asList(scanner.nextLine().split(" ")));

        Map<String, Integer> numberAndCounts = new LinkedHashMap<>();

        for (String value : values) {
            if (!numberAndCounts.containsKey(value)) {
                numberAndCounts.put(value, 1);
            } else {
                numberAndCounts.put(value, numberAndCounts.get(value) + 1);
            }
        }

        numberAndCounts.forEach((k, v) -> {
            System.out.printf("%.1f -> %d%n", Double.parseDouble(k), v);
        });
    }
}
