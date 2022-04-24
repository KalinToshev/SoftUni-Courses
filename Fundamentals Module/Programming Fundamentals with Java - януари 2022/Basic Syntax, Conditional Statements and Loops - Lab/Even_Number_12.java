package bg.softuni.Basic_Syntax_Conditional_Statements_and_Loops;

import java.util.Scanner;

public class Even_Number_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        int n = Integer.parseInt(scanner.nextLine());
        while (n % 2 != 0) {
            System.out.println("Please write an even number.");
            n = Integer.parseInt(scanner.nextLine());
            if (n % 2 == 0) {
                break;
            }
        }
        System.out.println("The number is: " + Math.abs(n));
    }
}
