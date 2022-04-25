package bg.softuni.ExerciseTextProcessing;

import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bigNumber = scanner.nextLine();
        int smallNumber = Integer.parseInt(scanner.nextLine());

        StringBuilder sb = new StringBuilder();
        
        int remainder = 0;
        getTheResult(bigNumber, smallNumber, sb, remainder);

        removeLeadingZeros(sb);

        System.out.println(sb);
    }

    private static void removeLeadingZeros(StringBuilder sb) {
        while (sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }
    }

    private static void getTheResult(String bigNumber, int smallNumber, StringBuilder sb, int remainder) {
        for (int i = bigNumber.length() - 1; i >= 0; i--) {
            int currentNumber = Integer.parseInt(String.valueOf(bigNumber.charAt(i)));
            int product = currentNumber * smallNumber + remainder;
            if (i == 0) {
                sb.insert(0, product);
            } else {
                int digitToAdd = product % 10;
                remainder = product / 10;
                sb.insert(0, digitToAdd);
            }
        }
    }
}
