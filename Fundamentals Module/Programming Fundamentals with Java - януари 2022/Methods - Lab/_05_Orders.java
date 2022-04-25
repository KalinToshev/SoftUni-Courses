package bg.softuni.MethodsLab;

import java.util.Scanner;

public class _05_Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());

        double result = 0.0;

        result(product, quantity, result);
    }
    static double result(String product, int quantity, double result) {
        switch (product) {
            case "water":
                result = quantity * 1.00;
                System.out.printf("%.2f", result);
                break;
            case "coffee":
                result = quantity * 1.50;
                System.out.printf("%.2f", result);
                break;
            case "coke":
                result = quantity * 1.40;
                System.out.printf("%.2f", result);
                break;
            case "snacks":
                result = quantity * 2.00;
                System.out.printf("%.2f", result);
                break;
        }
        return result;
    }
}
