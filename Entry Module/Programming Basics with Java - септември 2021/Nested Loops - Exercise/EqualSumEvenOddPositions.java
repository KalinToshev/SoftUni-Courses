package NestedLoops.exercises;

import java.util.Scanner;

public class EqualSumEvenOddPositions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());

        for (int i = n1; i <= n2; i++) {
            int number = i;
            int evenSum = 0;
            int oddSum = 0;
            for (int j = 6; j >= 1; j--) {
                // Взимам последната цифра
                int digit = number % 10;
                // Премахвам последната цифра
                number = number / 10;
                if (j % 2 == 0){
                    evenSum += digit;
                }else {
                    oddSum += digit;
                }
            }
            if (evenSum == oddSum){
                System.out.print(i + " ");
            }
        }
    }
}