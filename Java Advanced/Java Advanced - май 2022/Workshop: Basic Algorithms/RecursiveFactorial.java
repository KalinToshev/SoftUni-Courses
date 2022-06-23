package BasicAlgorithmsLab;

import java.util.Scanner;

public class RecursiveFactorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        System.out.println(recursiveFactorial(number));
    }
    public static int recursiveFactorial(int number) {
        if (number == 1) {
            return number;
        }
        return number * recursiveFactorial(number - 1);
    }
}
