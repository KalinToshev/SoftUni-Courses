package bg.softuni.Exercise_Basic_Syntax_Conditional_Statements_and_Loops;

import java.util.Scanner;

public class Print_and_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        int startNumber = Integer.parseInt(scanner.nextLine());
        int endNumber = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        //Calculate
        for (int i = startNumber; i <= endNumber; i++) {
            System.out.print(i + " ");
            sum += i;
        }
        System.out.println();
        System.out.println("Sum: " + sum);
    }
}
