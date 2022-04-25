package bg.softuni.MethodsLab;

import java.util.Scanner;

public class _03_PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printingTriangle(Integer.parseInt(scanner.nextLine()));
    }

    static void printingTriangle(int end) {
        for (int i = 1; i <= end; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        for (int i = end; i >= 1; i--) {
            for (int j = 1; j < i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
