package WorkingWithAbstractionExercise.GreedyTimes;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long capacityBag = Long.parseLong(scanner.nextLine());

        String[] inputData = scanner.nextLine().split("\\s+");

        var bag = new LinkedHashMap<String, LinkedHashMap<String, Long>>();
        long gold = 0;
        long gems = 0;
        long cash = 0;

        for (int i = 0; i < inputData.length; i += 2) {
            String name = inputData[i];
            long quantity = Long.parseLong(inputData[i + 1]);

            String type = saveType(name);

            if (breakRules(capacityBag, bag, quantity, type)) continue;

            switch (type) {
                case "Gem":
                    if (addGem(bag, quantity, type)) continue;
                    break;
                case "Cash":
                    if (addCash(bag, quantity, type)) continue;
                    break;
            }

            if (!bag.containsKey(type)) {
                bag.put((type), new LinkedHashMap<>());
            }

            if (!bag.get(type).containsKey(name)) {
                bag.get(type).put(name, 0L);
            }

            bag.get(type).put(name, bag.get(type).get(name) + quantity);
            switch (type) {
                case "Gold":
                    gold += quantity;
                    break;
                case "Gem":
                    gems += quantity;
                    break;
                case "Cash":
                    cash += quantity;
                    break;
            }
        }

        outputBag(bag);
    }

    private static boolean addCash(LinkedHashMap<String, LinkedHashMap<String, Long>> bag, long quantity, String type) {
        if (!bag.containsKey(type)) {
            if (bag.containsKey("Gem")) {
                return quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum();
            } else {
                return true;
            }
        } else
            return bag.get(type).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gem").values().stream().mapToLong(e -> e).sum();
    }

    private static String saveType(String name) {
        String type = "";

        if (name.length() == 3) {
            type = "Cash";
        } else if (name.toLowerCase().endsWith("gem")) {
            type = "Gem";
        } else if (name.equalsIgnoreCase("gold")) {
            type = "Gold";
        }
        return type;
    }

    private static void outputBag(LinkedHashMap<String, LinkedHashMap<String, Long>> bag) {
        for (var entry : bag.entrySet()) {
            Long sumValues = entry.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.printf("<%s> $%s%n", entry.getKey(), sumValues);

            entry.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static boolean addGem(LinkedHashMap<String, LinkedHashMap<String, Long>> bag, long quantity, String type) {
        if (!bag.containsKey(type)) {
            if (bag.containsKey("Gold")) {
                return quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum();
            } else {
                return true;
            }
        } else
            return bag.get(type).values().stream().mapToLong(e -> e).sum() + quantity > bag.get("Gold").values().stream().mapToLong(e -> e).sum();
    }

    private static boolean breakRules(long capacityBag, LinkedHashMap<String, LinkedHashMap<String, Long>> bag, long quantity, String type) {
        if (type.equals("")) {
            return true;
        } else return capacityBag < bag.values().stream()
                .map(Map::values)
                .flatMap(Collection::stream)
                .mapToLong(e -> e).sum() + quantity;
    }
}