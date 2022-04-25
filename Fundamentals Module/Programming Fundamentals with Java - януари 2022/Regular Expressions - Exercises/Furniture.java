package bg.softuni.ExerciseRegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> products = new ArrayList<>();

        Pattern pattern = Pattern.compile(">>(?<productName>[A-Za-z]+)<<(?<price>\\d+\\.\\d+|\\d+)!(?<quantity>\\d+)\\b");

        String line = scanner.nextLine();

        double totalPrice = 0.0;

        while (!line.equals("Purchase")) {
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String name = matcher.group("productName");
                double price = Double.parseDouble(matcher.group("price"));
                int quantity = Integer.parseInt(matcher.group("quantity"));
                products.add(name);
                totalPrice += price * quantity;
            }

            line = scanner.nextLine();
        }

        System.out.println("Bought furniture:");
        products.forEach(System.out::println);
        System.out.printf("Total money spend: %.2f", totalPrice);
    }
}
