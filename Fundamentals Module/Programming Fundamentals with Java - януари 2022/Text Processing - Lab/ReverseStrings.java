package bg.softuni.TextProcessingLab;

import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        while (!line.equals("end")) {
            StringBuilder reversedWord = new StringBuilder();
            char[] ch = line.toCharArray();
            for (int i = ch.length - 1; i >= 0; i--) {
                 reversedWord.append(ch[i]);
            }
            System.out.println(line + " = " + reversedWord);
            line = scanner.nextLine();
        }
    }
}
