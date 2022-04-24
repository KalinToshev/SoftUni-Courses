package bg.softuni.Data_Types_and_Variables_Lab;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int currentNumber;
        for (int i = 1; i <= n; i++) {
            currentNumber = i;
            while (currentNumber > 0) {
                sum += currentNumber % 10;
                currentNumber /= 10;
            }
            if((sum == 5) || (sum == 7) || (sum == 11)) {
                System.out.printf("%d -> %s%n", i, "True");
            } else {
                System.out.printf("%d -> %s%n", i, "False");
            }
            sum = 0;
        }
    }
}
