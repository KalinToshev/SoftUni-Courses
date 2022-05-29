import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> continentsCountriesCities = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        fillMap(scanner, continentsCountriesCities, n);

        output(continentsCountriesCities);
    }

    private static void fillMap(Scanner scanner, Map<String, Map<String, List<String>>> continentsCountriesCities, int n) {
        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\s+");
            String continent = line[0];
            String country = line[1];
            String city = line[2];

            continentsCountriesCities.putIfAbsent(continent, new LinkedHashMap<>());
            continentsCountriesCities.get(continent).putIfAbsent(country, new ArrayList<>());
            continentsCountriesCities.get(continent).get(country).add(city);

        }
    }

    private static void output(Map<String, Map<String, List<String>>> continentsCountriesCities) {
        for (Map.Entry<String, Map<String, List<String>>> continent : continentsCountriesCities.entrySet()) {
            System.out.printf("%s:%n", continent.getKey());
            for (Map.Entry<String, List<String>> country : continent.getValue().entrySet()) {
                System.out.printf("%s -> %s%n", country.getKey(), String.join(", ", country.getValue()));
            }
        }
    }
}
