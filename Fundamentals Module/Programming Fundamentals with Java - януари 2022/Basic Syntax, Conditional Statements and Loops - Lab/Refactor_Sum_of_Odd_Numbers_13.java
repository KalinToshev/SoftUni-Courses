package bg.softuni.Basic_Syntax_Conditional_Statements_and_Loops;

import java.util.Scanner;

public class Refactor_Sum_of_Odd_Numbers_13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int sum = 1;
        for (int i = 1; i < n; i++) {
            System.out.print(2 * i + "\n");
            sum += 2 * i + 1;
        }
        System.out.printf("Sum: %d%n", sum - 1);
    }
}
