package EncapsulationExercise.PizzaCalories;

import java.util.Scanner;

public class Main {
    static String[] input = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        input = scanner.nextLine().split("\\s+"); //read pizza

        Pizza pizza = new Pizza(input[1], Integer.parseInt(input[2]));

        input = scanner.nextLine().split("\\s+"); //read dough

        Dough dough = new Dough(input[1], input[2], Double.parseDouble(input[3]));
        pizza.setDough(dough);

        input = scanner.nextLine().split("\\s+"); //read topping;

        while (!"END".equals(input[0])) {
            Topping topping = new Topping(input[1], Double.parseDouble(input[2]));
            pizza.addTopping(topping);
            input = scanner.nextLine().split("\\s+");
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
