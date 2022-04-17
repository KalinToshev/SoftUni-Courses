import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        char operation = scanner.nextLine().charAt(0);

        double result = 0;

        switch (operation) {
            case '+':
                result = firstNumber + secondNumber;
                break;
            case '-':
                result = firstNumber - secondNumber;
                break;
            case '*':
                result = firstNumber * secondNumber;
                break;
            case '/':
                if (secondNumber == 0) {
                    System.out.printf("Cannot divide %d by zero", firstNumber);
                    return;
                }

                result = firstNumber * 1.0 / secondNumber;
                break;
            case '%':
                if (secondNumber == 0) {
                    System.out.printf("Cannot divide %d by zero", firstNumber);
                    return;
                }

                result = firstNumber % secondNumber;
                break;
        }

        if (operation == '+' || operation == '-' || operation == '*') {
            String evenOrOdd = result % 2 == 0 ?
                    "even" :
                    "odd";

            System.out.printf("%d %c %d = %.0f - %s",
                    firstNumber, operation, secondNumber, result, evenOrOdd);
        } else if (operation == '/') {
            System.out.printf("%d %c %d = %.2f",
                    firstNumber, operation, secondNumber, result);
        } else if (operation == '%') {
            System.out.printf("%d %c %d = %.0f",
                    firstNumber, operation, secondNumber, result);
        }
    }
}
