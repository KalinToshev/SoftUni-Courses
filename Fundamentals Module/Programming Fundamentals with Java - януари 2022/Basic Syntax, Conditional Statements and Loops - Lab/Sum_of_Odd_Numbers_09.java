package bg.softuni.Basic_Syntax_Conditional_Statements_and_Loops;

import java.util.Scanner;

public class Sum_of_Odd_Numbers_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int odd_number_counter = 0;
        for (int i = 1; ; i++) {
            if (i % 2 != 0) {
                System.out.println(i);
                sum += i;
                odd_number_counter++;
            }
            if (odd_number_counter == n) {
                break;
            }
        }
        //Output
        System.out.println("Sum: " + sum);
    }
}
