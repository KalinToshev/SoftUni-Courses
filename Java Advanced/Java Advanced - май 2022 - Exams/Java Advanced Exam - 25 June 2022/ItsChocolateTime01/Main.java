package JavaAdvancedExam25June2022.ItsChocolateTime01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Double> milkQuantity = new ArrayDeque<>(); //queue
        Deque<Double> powderValues = new ArrayDeque<>(); //stack

        Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).forEach(milkQuantity::offer);
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).forEach(powderValues::push);

        Map<String, Integer> chocolatesMade = new TreeMap<>();
        chocolatesMade.put("Milk Chocolate", 0);
        chocolatesMade.put("Dark Chocolate", 0);
        chocolatesMade.put("Baking Chocolate", 0);

        while (!(milkQuantity.isEmpty() || powderValues.isEmpty())) {
            double singleMilkValue = milkQuantity.poll();
            double singlePowderValue = powderValues.pop();

            int chocolatePercentage = (int) Math.round(((singlePowderValue / (singlePowderValue + singleMilkValue)) * 100));

           switch (chocolatePercentage) {
               case 30:
                    chocolatesMade.put("Milk Chocolate", chocolatesMade.get("Milk Chocolate") + 1);
                   break;
               case 50:
                   chocolatesMade.put("Dark Chocolate", chocolatesMade.get("Dark Chocolate") + 1);
                   break;
               case 100:
                   chocolatesMade.put("Baking Chocolate", chocolatesMade.get("Baking Chocolate") + 1);
                   break;
               default:
                   singleMilkValue += 10;
                   milkQuantity.offerLast(singleMilkValue);
                   break;
           }
        }

        int chocolateTypes = 0;
        for (Map.Entry<String, Integer> entry : chocolatesMade.entrySet()) {
            if (entry.getValue() > 0) {
                chocolateTypes++;
            }
        }

        if (chocolateTypes == 3) {
            System.out.println("It’s a Chocolate Time. All chocolate types are prepared.");
        } else {
            System.out.println("Sorry, but you didn't succeed to prepare all types of chocolates.");
        }

        for (Map.Entry<String, Integer> entry : chocolatesMade.entrySet()) {
            if (entry.getValue() > 0) {
                System.out.println(" # " + entry.getKey() + " --> " + entry.getValue());
            }
        }
    }
}
