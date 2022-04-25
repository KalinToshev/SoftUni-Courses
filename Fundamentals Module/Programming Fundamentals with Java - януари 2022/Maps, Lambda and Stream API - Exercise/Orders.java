package bg.softuni.MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //TODO: Create a program, which keeps the information about products and their prices.
        //Each product has a: name, price, quantity
        //If product doesn't exist - add it with its starting quantity and price
        //If product exist => increase its quantity by the input quantity; if it's price is DIFF >> replace price
        //You will receive product's names, prices and quantities on new lines, until receive command "buy"

        Map<String, List<Double>> products = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!line.equals("buy")) {

            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            double quantity = Double.parseDouble(tokens[2]);

            if (products.containsKey(name)) {
                products.get(name).set(0, price);
                products.get(name).set(1, products.get(name).get(1) + quantity);
            } else {
                products.put(name, new ArrayList<>());
                products.get(name).add(price);
                products.get(name).add(quantity);
            }

            line = scanner.nextLine();
        }
        products.forEach((k, v) -> System.out.printf("%s -> %.2f%n", k, v.get(0) * v.get(1)));
    }
}
