import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Long>> populationCounter = new LinkedHashMap<>();

        String line;
        while (!"report".equals(line = scanner.nextLine())) {
            String city = line.split("\\|")[0];
            String country = line.split("\\|")[1];
            long population = Long.parseLong(line.split("\\|")[2]);

            //Add the info
            populationCounter.putIfAbsent(country, new LinkedHashMap<>());
            populationCounter.get(country).put(city, population);
        }

        Map<String, Long> populationCounterSorted = new LinkedHashMap<>();
        for (var entry : populationCounter.entrySet()) {
            //Sum population
            long sum = entry.getValue().values().stream().mapToLong(e ->e).sum();

            //Add to the new map
            populationCounterSorted.put(entry.getKey(), sum);
        }

        //Sort new map and output
        populationCounterSorted.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(e -> {
            System.out.printf("%s (total population: %s)%n", e.getKey(), e.getValue());
            populationCounter.get(e.getKey()).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(s -> System.out.printf("=>%s: %s%n", s.getKey(), s.getValue()));
        });
    }
}
