package bg.softuni.ExerciseTextProcessing;

import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder sb = new StringBuilder(scanner.nextLine());

        findsTwoConsecutiveEqualLettersAndRemovesTheFirstOne(sb);

        System.out.println(sb);
    }

    private static void findsTwoConsecutiveEqualLettersAndRemovesTheFirstOne(StringBuilder sb) {
        for (int i = 0; i < sb.length() - 1; i++) {
            char currentDigit = sb.charAt(i);
            char nextDigit = sb.charAt(i + 1);
            if (currentDigit == nextDigit) {
                sb.deleteCharAt(i);
                i--;
            }
        }
    }
}
