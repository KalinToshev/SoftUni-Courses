package bg.softuni.MethodsExercise;

import java.util.Scanner;

public class _08_FactorialDivision {
    public static void main(String[] args) {
        //Create a scanner
        Scanner scanner = new Scanner(System.in);
        //Read two numbers from the console
        double num1 = Double.parseDouble(scanner.nextLine());
        double num2 = Double.parseDouble(scanner.nextLine());
        //Creates two variables to hold the result of the factorials, and divide
        double factorialOne = findFactorialOfNumbers(num1);
        double factorialTwo = findFactorialOfNumbers(num2);
        double divideResult = factorialOne / factorialTwo;
        //Print the result
        printResult(divideResult);
    }
    //Find factorial of the numbers
    static double findFactorialOfNumbers(double number) {
        //Create a local variable to hold the factorial result
        double factorialResult = 1.0;
        //Create a for loop to calculate the factorial
        for (int i = 1; i <= number; i++) {
            factorialResult *= i;
        }
        return factorialResult;
    }
    //Print the result on the console
    static void printResult(double divideResult) {
        System.out.printf("%.2f", divideResult);
    }
}
