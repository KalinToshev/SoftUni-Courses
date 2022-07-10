package InterfacesAndAbstractionExercise.FoodShortage;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numbersOfInput = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyers = new HashMap<>();

        Buyer buyer;

        while (numbersOfInput-- > 0){
            String[] attributes = scanner.nextLine().split("\\s+");
            String name = attributes[0];
            int age = Integer.parseInt(attributes[1]);

            if(attributes.length == 4) {
                String id = attributes[2];
                String birthdate = attributes[3];
                buyer = new Citizen(name, age, id, birthdate);

            } else {
                String group = attributes[2];
                buyer = new Rebel(name, age, group);
            }

            buyers.put(name, buyer);
        }

        String bayer;

        while (!"End".equals(bayer = scanner.nextLine())){
            if(buyers.containsKey(bayer)){
                buyers.get(bayer).buyFood();
            }
        }

        int totalFood = buyers.values().stream().mapToInt(Buyer::getFood).sum();
        System.out.println(totalFood);
    }
}
