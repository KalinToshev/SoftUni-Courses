package bg.softuni.TextProcessingLab;

import java.util.Scanner;

public class RepeatStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arr = scanner.nextLine().split("\\s+");

        String endResult = "";

        for (String currentWord : arr) {
            char[] ch = currentWord.toCharArray();
            for (int i1 = 0; i1 < ch.length; i1++) {
                endResult = endResult.concat(currentWord);
            }
        }
        System.out.println(endResult);
    }
}
