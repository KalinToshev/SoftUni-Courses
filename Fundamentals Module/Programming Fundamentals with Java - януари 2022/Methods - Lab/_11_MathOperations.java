package bg.softuni.MethodsLab;

import java.util.Scanner;

public class _11_MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        int number2 = Integer.parseInt(scanner.nextLine());

        printTheResultByGivenOperator(number1, operator, number2);

    }

    private static void printTheResultByGivenOperator(int number1, String operator, int number2) {
        switch (operator) {
            case "+":
                System.out.println(addNumbers(number1, number2));
                break;
            case "/":
                System.out.println(divideNumbers(number1, number2));
                break;
            case "*":
                System.out.println(multiplyNumbers(number1, number2));
                break;
            case "-":
                System.out.println(subtractNumbers(number1, number2));
                break;
        }
    }

    static int addNumbers(int number1, int number2) {
        return number1 + number2;
    }

    static int divideNumbers(int number1, int number2) {
        return number1 / number2;
    }

    static int multiplyNumbers(int number1, int number2) {
        return number1 * number2;
    }

    static int subtractNumbers(int number1, int number2) {
        return number1 - number2;
    }
}
