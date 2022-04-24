package bg.softuni.Exercise_Basic_Syntax_Conditional_Statements_and_Loops;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        int group_of_people = Integer.parseInt(scanner.nextLine());
        String type_of_group = scanner.nextLine();
        String day_of_week = scanner.nextLine();
        double price = 0.0;
        double total_price = 0.0;
        //Calculate
        switch (day_of_week) {
            case "Friday":
                switch (type_of_group) {
                    case "Students":
                        price = 8.45;
                        total_price = group_of_people * price;
                        if (group_of_people >= 30) {
                            total_price = total_price - (total_price * 0.15);
                        }
                        break;
                    case "Business":
                        price = 10.90;
                        total_price = group_of_people * price;
                        if (group_of_people >= 100) {
                            total_price = total_price - (10 * price);
                        }
                        break;
                    case "Regular":
                        price = 15;
                        total_price = group_of_people * price;
                        if (group_of_people >= 10 && group_of_people <= 20) {
                            total_price = total_price - (total_price * 0.05);
                        }
                        break;
                }
                break;
            case "Saturday":
                switch (type_of_group) {
                    case "Students":
                        price = 9.80;
                        total_price = group_of_people * price;
                        if (group_of_people >= 30) {
                            total_price = total_price - (total_price * 0.15);
                        }
                        break;
                    case "Business":
                        price = 15.60;
                        total_price = group_of_people * price;
                        if (group_of_people >= 100) {
                            total_price = total_price - (10 * price);
                        }
                        break;
                    case "Regular":
                        price = 20;
                        total_price = group_of_people * price;
                        if (group_of_people >= 10 && group_of_people <= 20) {
                            total_price = total_price - (total_price * 0.05);
                        }
                        break;
                }
                break;
            case "Sunday":
                switch (type_of_group) {
                    case "Students":
                        price = 10.46;
                        total_price = group_of_people * price;
                        if (group_of_people >= 30) {
                            total_price = total_price - (total_price * 0.15);
                        }
                        break;
                    case "Business":
                        price = 16;
                        total_price = group_of_people * price;
                        if (group_of_people >= 100) {
                            total_price = total_price - (10 * price);
                        }
                        break;
                    case "Regular":
                        price = 22.50;
                        total_price = group_of_people * price;
                        if (group_of_people >= 10 && group_of_people <= 20) {
                            total_price = total_price - (total_price * 0.05);
                        }
                        break;
                }
                break;
        }
        //Output
        System.out.printf("Total price: %.2f", total_price);
    }
}
