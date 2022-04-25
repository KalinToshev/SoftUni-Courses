package bg.softuni.MethodsExercise;

import java.util.Scanner;

public class _05_AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Read two numbers from console
        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());
        //Calculate the result from num1 + num2
        int addResult = sumTheFirstTwoNumbers(num1, num2);
        //Subtract the add result from third number
        int result = addResult - num3;
        //Output the result
        System.out.println(result);
    }
    static int sumTheFirstTwoNumbers(int num1, int num2) {
        return num1 + num2;
    }
}
