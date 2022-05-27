import java.util.*;
import java.util.stream.Collectors;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> studentAndGrades = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            studentAndGrades.putIfAbsent(input[0], new ArrayList<>());
            studentAndGrades.get(input[0]).add(Double.parseDouble(input[1]));
        }

        for (Map.Entry<String, List<Double>> entry : studentAndGrades.entrySet()) {
            double avgScore = 0;
            for (Double d : entry.getValue()) {
                avgScore += d;
            }
            avgScore /= entry.getValue().size();

            List<String> tmp = entry.getValue().stream()
                    .map(e -> String.format("%.2f", e))
                    .collect(Collectors.toList());
            String scores = String.join(" ", tmp);
            
            System.out.printf("%s -> %s (avg: %.2f)%n", entry.getKey(), scores, avgScore);
        }
    }
}
