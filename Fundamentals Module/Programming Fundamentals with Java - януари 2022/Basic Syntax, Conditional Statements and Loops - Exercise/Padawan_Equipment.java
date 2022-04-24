package bg.softuni.Exercise_Basic_Syntax_Conditional_Statements_and_Loops;

import java.util.Scanner;

public class Padawan_Equipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        double amount_of_money = Double.parseDouble(scanner.nextLine());
        int count_of_students = Integer.parseInt(scanner.nextLine());
        double price_of_lightsabers = Double.parseDouble(scanner.nextLine());
        double price_of_robes = Double.parseDouble(scanner.nextLine());
        double price_of_belts = Double.parseDouble(scanner.nextLine());
        //Calculate
        double saberCount = Math.ceil(count_of_students * 1.10);
        int belts_count = count_of_students - count_of_students / 6;
        double total_price =  saberCount * price_of_lightsabers + price_of_robes * count_of_students + price_of_belts * belts_count;
        //Output
        if (amount_of_money >= total_price) {
            System.out.printf("The money is enough - it would cost %.2flv.", total_price);
        } else {
            System.out.printf("George Lucas will need %.2flv more.", total_price - amount_of_money);
        }
    }
}
