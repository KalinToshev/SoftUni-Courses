package bg.softuni.MethodsExercise;

import java.util.Scanner;

public class _07_NxNMatrix {
    public static void main(String[] args) {
        //Create a scanner
        Scanner scanner = new Scanner(System.in);
        //Read an input and save it
        int n = Integer.parseInt(scanner.nextLine());
        //Print the result
        printNxNMatrix(n);
    }
    //Create a method who will print on the console NxN Matrix with that number
    static void printNxNMatrix(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(n + " ");
            }
            System.out.println();
        }
    }
}
