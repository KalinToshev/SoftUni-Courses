import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> legends = new TreeMap<>();

        legends.put("shards", 0);
        legends.put("fragments", 0);
        legends.put("motes", 0);

        Map<String, Integer> trash = new TreeMap<>();

        while (true) {
            String[] materials = scanner.nextLine().split("\\s+");
            for (int i = 0; i < materials.length; i += 2) {
                int quantity = Integer.parseInt(materials[i]);
                String material = (materials[i + 1]).toLowerCase();

                if (material.equals("shards") || material.equals("motes") || material.equals("fragments")) {
                    legends.put(material, legends.get(material) + quantity);
                    if (legends.get(material) >= 250) {
                        legends.put(material, legends.get(material) - 250);
                        winner(trash, legends, material);
                        return;
                    }
                } else {
                    trash.putIfAbsent(material, 0);
                    trash.put(material, trash.get(material) + quantity);
                }

//            switch (material) {
//                case "shards":
//                        legends.put("shards", legends.get("shards") + quantity);
//                        break;
//                case "fragments":
//                        legends.put("fragments", legends.get("fragments") + quantity);
//                        break;
//                case "motes":
//                        legends.put("motes", legends.get("motes") + quantity);
//                        break;
//                default:
//                    if (!trash.containsKey(material)) {
//                        trash.put(material, quantity);
//                    } else {
//                        trash.put(material, trash.get(material) + quantity);
//                    }
//            }
//            if (legends.get("shards") >= 250) {
//                legends.put("shards", legends.get("shards") - 250);
//                System.out.printf("%s obtained!%n", "Shadowmourne");
//            } else if (legends.get("fragments") >= 250) {
//                legends.put("fragments", legends.get("fragments") - 250);
//                System.out.printf("%s obtained!%n", "Valanyr");
//            } else if (legends.get("motes") >= 250) {
//                legends.put("motes", legends.get("motes") - 250);
//                System.out.printf("%s obtained!%n", "Dragonwrath");
//            }
            }
        }
    }

    private static void winner(Map<String, Integer> trash, Map<String, Integer> legends, String material) {
        if (material.equals("shards")) {
            System.out.println("Shadowmourne obtained!");
        } else if (material.equals("motes")) {
            System.out.println("Dragonwrath obtained!");
        } else if (material.equals("fragments")) {
            System.out.println("Valanyr obtained!");
        }

        legends.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));
        trash.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
