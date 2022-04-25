package bg.softuni.MapsLambdaAndStreamAPIExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean hasWinner = false;

        Map<String, Integer> items = new LinkedHashMap<>();
        items.put("shards", 0);
        items.put("fragments", 0);
        items.put("motes", 0);

        String winner = "";

        while (!hasWinner) {
            String[] data = scanner.nextLine().split("\\s+");
            for (int i = 0; i < data.length - 1; i+=2) {
                int quantity = Integer.parseInt(data[i]);
                String resources = data[i + 1].toLowerCase();
                items.putIfAbsent(resources, 0);
                items.put(resources, items.get(resources) + quantity);
                if (resources.equals("shards") || resources.equals("fragments") || resources.equals("motes")) {
                    if (items.get(resources) >= 250) {
                        items.put(resources, items.get(resources) - 250);
                        winner = resources;
                        hasWinner = true;
                        break;
                    }
                }
            }
        }
        switch (winner) {
            case "shards":
                System.out.println("Shadowmourne obtained!");
                break;
            case "fragments":
                System.out.println("Valanyr obtained!");
                break;
            case "motes":
                System.out.println("Dragonwrath obtained!");
                break;
        }
        items.forEach((key, value) -> System.out.printf("%s: %d%n", key, value));
    }
}
