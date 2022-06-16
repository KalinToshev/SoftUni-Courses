package JavaAdvancedRetakeExam13April2022.Blacksmith01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //count sword collection
        Map<String, Integer> swords = new TreeMap<>();
        swords.put("Sabre", 0);
        swords.put("Katana", 0);
        swords.put("Shamshir", 0);
        swords.put("Gladius", 0);

        //Swords
        int Gladius = 70;
        int Shamshir = 80;
        int Katana = 90;
        int Sabre = 110;

        //get the steel and carbon
        String sequencesOfSteel = scanner.nextLine();
        String sequencesOfCarbon = scanner.nextLine();

        //save the info about the steel and the carbon
        Deque<Integer> carbon = new ArrayDeque<>(); //stack
        Arrays.stream(sequencesOfCarbon.split(" ")).mapToInt(Integer::parseInt).forEach(carbon::push);
        Deque<Integer> steel = new ArrayDeque<>(); //queue
        Arrays.stream(sequencesOfSteel.split(" ")).mapToInt(Integer::parseInt).forEach(steel::offer);

        //while carbon || steel <= 0 STOP
        //remove first steel and pop last carbon
        //if steel + carbon = swords points -> pop carbon and poll steel => create sword
        //else poll steel and increment the last value of the carbon with 5 and return it to the collection
        int swordsCrafted = 0;
        while (carbon.size() >= 1 && steel.size() >= 1) {
            int carb = carbon.pop();
            int stl = steel.remove();
            if (stl + carb == Gladius || stl + carb == Shamshir || stl + carb == Katana || stl + carb == Sabre) {
                int points = stl + carb;
                switch (points) {
                    case 70:
                        swords.put("Gladius", swords.get("Gladius") + 1);
                        swordsCrafted++;
                        break;
                    case 80:
                        swords.put("Shamshir", swords.get("Shamshir") + 1);
                        swordsCrafted++;
                        break;
                    case 90:
                        swords.put("Katana", swords.get("Katana") + 1);
                        swordsCrafted++;
                        break;
                    case 110:
                        swords.put("Sabre", swords.get("Sabre") + 1);
                        swordsCrafted++;
                        break;
                }
            }  else {
                carb += 5;
                carbon.push(carb);
            }
        }
        //output 1
        boolean crafted = false;
        if (swordsCrafted > 0) {
            System.out.printf("You have forged %d swords.%n", swordsCrafted);
            crafted = true;
        } else {
            System.out.printf("You did not have enough resources to forge a sword.%n");
        }
        //output 2
        if (steel.isEmpty()) {
            System.out.printf("Steel left: none%n");
        } else {
            System.out.print("Steel left: ");
            List<String> steelLeft = new ArrayList<>();
            for (Integer integer : steel) {
                steelLeft.add(integer.toString());
            }
            System.out.println(String.join(", ", steelLeft));
        }
        //output 3
        if (carbon.isEmpty()) {
            System.out.printf("Carbon left: none%n");
        } else {
            System.out.print("Carbon left: ");
            List<String> carbonLeft = new ArrayList<>();
            for (Integer integer : carbon) {
                carbonLeft.add(integer.toString());
            }
            System.out.println(String.join(", ", carbonLeft));
        }
        //output 4
        if (crafted) {
            swords.forEach((k, v) -> {
                if (v > 0) {
                    System.out.printf("%s: %d%n", k, v);
                }
            });
        }
    }
}
