package bg.softuni.Basic_Syntax_Conditional_Statements_and_Loops;

import java.util.Scanner;

public class Multiplication_Table_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        int n = Integer.parseInt(scanner.nextLine());
        //Output
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " X " + i + " = " + n*i);
        }
    }
}
