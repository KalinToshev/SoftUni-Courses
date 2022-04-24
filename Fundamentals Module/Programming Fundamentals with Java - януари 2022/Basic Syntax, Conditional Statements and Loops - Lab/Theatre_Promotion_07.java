package bg.softuni.Basic_Syntax_Conditional_Statements_and_Loops;

import java.util.Scanner;

public class Theatre_Promotion_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        String type_of_day = scanner.nextLine().toLowerCase();
        int age = Integer.parseInt(scanner.nextLine());
        double price = 0.0;

        if (type_of_day.equals("weekday")) {
            if ((age >= 0 && age <= 18) || (age > 64 && age <= 122)) {
                price = 12;
            } else if (age > 18 && age <= 64) {
                price = 18;
            }
        } else if (type_of_day.equals("weekend")) {
            if ((age >= 0 && age <= 18) || (age > 64 && age <= 122)) {
                price = 15;
            } else if (age > 18 && age <= 64) {
                price = 20;
            }
        } else if (type_of_day.equals("holiday")) {
            if (age >= 0 && age <= 18) {
                price = 5;
            } else if (age > 18 && age <= 64) {
                price = 12;
            } else if (age > 64 && age <= 122) {
                price = 10;
            }
        }
        if (price > 0) {
            System.out.printf("%.0f$", price);
        } else {
            System.out.printf("Error!");
        }
    }
}
