import java.util.Scanner;

public class OddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int oddSum = 0;
        int evenSum = 0;
        for (int i = 1; i <= n; i++) {
            int element = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0) {
                evenSum += element;
            } else {
                oddSum += element;
            }
        }
        if (evenSum == oddSum) {
            System.out.printf("Yes%n");
            System.out.printf("Sum = %d", evenSum);
        }
        if (evenSum != oddSum) {
            System.out.printf("No%n");
            System.out.printf("Diff = %d", Math.abs(oddSum - evenSum));
        }
    }
}
