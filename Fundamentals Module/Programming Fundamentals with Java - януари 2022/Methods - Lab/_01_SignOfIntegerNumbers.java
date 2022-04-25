package bg.softuni.MethodsLab;

import java.util.Scanner;

public class _01_SignOfIntegerNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printSignOfAnIntegerNumber(scanner.nextInt());
    }
    static void printSignOfAnIntegerNumber(int number) {
        if (number > 0) {
            System.out.printf("The number %d is positive.", number);
        } else if (number == 0) {
            System.out.println("The number 0 is zero.");
        } else {
            System.out.printf("The number %d is negative.", number);
        }
    }
}
