package bg.softuni.MethodsLab;

import java.util.Arrays;
import java.util.Scanner;

public class _10_MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Math.abs(Integer.parseInt(scanner.nextLine()));

        System.out.println(getMultipleOfEvensAndOdds(num));
    }

    static int getMultipleOfEvensAndOdds(int num) {
        return getEvenSum(num) * getOddSum(num);
    }

    static int getEvenSum(int num) {
        String intToString = Integer.toString(num);

        int[] numArray = Arrays.stream(intToString.split("")).mapToInt(Integer::parseInt).toArray();

        int evenSum = 0;
        for (int j : numArray) {
            if (j % 2 == 0) {
                evenSum += j;
            }
        }
        return evenSum;
    }

    static int getOddSum(int num) {
        String intToString = Integer.toString(num);

        int[] numArray = Arrays.stream(intToString.split("")).mapToInt(Integer::parseInt).toArray();

        int oddSum = 0;
        for (int j : numArray) {
            if (j % 2 == 1) {
                oddSum += j;
            }
        }
        return oddSum;
    }
}
