import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrubskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, LinkedHashMap<String, Integer>> aggregateData = new LinkedHashMap<>();

        //regex
        Pattern pattern = Pattern.compile("^(?<singer>[A-z ]+) @(?<venue>[A-z ]+) (?<ticketsPrice>[0-9]+) (?<ticketsCount>[0-9]+)$");

        String inputData;
        while (!"End".equals(inputData = scanner.nextLine())) {
            //data line separated
            String singer = "";
            String venue = "";
            int ticketsPrice = 0;
            int ticketsCount = 0;

            //fill data line
            Matcher matcher = pattern.matcher(inputData);
            if (matcher.find()) {
                singer = matcher.group("singer");
                venue = matcher.group("venue");
                ticketsPrice = Integer.parseInt(matcher.group("ticketsPrice"));
                ticketsCount = Integer.parseInt(matcher.group("ticketsCount"));
            }

            //fill the map
            aggregateData.putIfAbsent(venue, new LinkedHashMap<>());
            aggregateData.get(venue).putIfAbsent(singer, 0);
            aggregateData.get(venue).put(singer, aggregateData.get(venue).get(singer) + (ticketsCount * ticketsPrice));
        }

        //output
        aggregateData.forEach((k, v) -> {
            System.out.println(k);
            v.entrySet().stream()
                    .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                    .forEach(s -> System.out.println("#  " + s.getKey() + " -> " + s.getValue()));
        });
    }
}
