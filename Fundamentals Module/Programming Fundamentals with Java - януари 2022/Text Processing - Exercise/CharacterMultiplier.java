package bg.softuni.ExerciseTextProcessing;

import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalSum = 0;

        String[] data = scanner.nextLine().split("\\s+");

        String data1 = data[0];
        String data2 = data[1];

        char[] ch1 = data1.toCharArray();
        char[] ch2 = data2.toCharArray();

        totalSum = getTotalSumOfTwoStrings(totalSum, ch1, ch2);

        System.out.println(totalSum);
    }

    private static int getTotalSumOfTwoStrings(int totalSum, char[] ch1, char[] ch2) {
        if (ch1.length > ch2.length) {
            for (int i = 0; i < ch2.length; i++) {
                totalSum += ch2[i] * ch1[i];
            }
            for (int i = ch2.length; i < ch1.length; i++) {
                totalSum += ch1[i];
            }
        } else {
            for (int i = 0; i < ch1.length; i++) {
                totalSum += ch2[i] * ch1[i];
            }
            for (int i = ch1.length; i < ch2.length; i++) {
                totalSum += ch2[i];
            }
        }
        return totalSum;
    }
}
