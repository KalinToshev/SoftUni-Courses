package bg.softuni.Exercise_Basic_Syntax_Conditional_Statements_and_Loops;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        int count_of_the_orders = Integer.parseInt(scanner.nextLine());
        double price_per_capsule = 0.0;
        int days = 0;
        int capsules_count = 0;
        double price = 0.0;
        double total_price = 0.0;
        //Compute
        for (int i = 1; i <= count_of_the_orders; i++) {
            price_per_capsule = Double.parseDouble(scanner.nextLine());
            days = Integer.parseInt(scanner.nextLine());
            capsules_count = Integer.parseInt(scanner.nextLine());
            price = ((days * capsules_count) * price_per_capsule);
            //Output 1
            System.out.printf("The price for the coffee is: $%.2f%n", price);
            total_price += price;
        }
        //Output 2
        System.out.printf("Total: $%.2f", total_price);
    }
}
