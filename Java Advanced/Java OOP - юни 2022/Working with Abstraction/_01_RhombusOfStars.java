package WorkingWithAbstractionLab;

import java.util.Scanner;

public class _01_RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int size = Integer.parseInt(scanner.nextLine());

        printTopHalf(size);
        printBottomHalf(size);
    }

    private static void printTopHalf(int size) {
        for (int starCount = 1; starCount <= size; starCount++) {
            printRow(size, starCount);
        }
    }

    private static void printBottomHalf(int size) {
        for (int starCount = size - 1; starCount > 0; starCount--) {
            printRow(size, starCount);
        }
    }

    private static void printRow(int size, int starCount) {
        for (int j = 0; j < size - starCount; j++) {
            System.out.print(" ");
        }
        for (int j = 0; j < starCount - 1; j++) {
            System.out.print("* ");
        }
        System.out.println("*");
    }
}
