package bg.softuni.Exercise_Basic_Syntax_Conditional_Statements_and_Loops;

import java.util.Scanner;

public class Rage_Expenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());
        //Calculate
        double expenses = 0.0;
        int keyboardTrashes = 0;
        for (int i = 1; i <= lostGames; i++) {
            if (i % 2 == 0) {
                expenses += headsetPrice;
            }
            if (i % 3 == 0) {
                expenses += mousePrice;
            }
            if (i % 2 == 0 && i % 3 == 0) {
                keyboardTrashes++;
                expenses += keyboardPrice;
                if (keyboardTrashes % 2 == 0) {
                    expenses += displayPrice;
                }
            }
        }
        System.out.printf("Rage expenses: %.2f lv.", expenses);
    }
}
