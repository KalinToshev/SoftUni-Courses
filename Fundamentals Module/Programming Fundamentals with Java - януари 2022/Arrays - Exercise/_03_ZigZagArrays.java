package bg.softuni.ArraysExercise;
import java.util.Scanner;

public class _03_ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arrOne = new int[n];
        int[] arrTwo = new int[n];
        for (int i = 0; i < n; i++) {
            int n1 = Integer.parseInt(scanner.next());
            int n2 = Integer.parseInt(scanner.next());
            if (i == 0) {
                arrOne[0] = n1;
                arrTwo[0] = n2;
            }
            if (i % 2 == 1) {
                arrOne[i] = n2;
                arrTwo[i] = n1;
            }
            if (i % 2 == 0) {
                arrOne[i] = n1;
                arrTwo[i] = n2;
            }
        }
        for (int j : arrOne) {
            System.out.print(j + " ");
        }
        System.out.println();
        for (int j : arrTwo) {
            System.out.print(j + " ");
        }
    }
}