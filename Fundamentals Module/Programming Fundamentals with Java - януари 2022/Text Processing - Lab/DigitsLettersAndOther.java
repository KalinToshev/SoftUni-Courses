package bg.softuni.TextProcessingLab;

import java.util.Scanner;

public class DigitsLettersAndOther {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        StringBuilder digit = new StringBuilder();
        StringBuilder letter = new StringBuilder();
        StringBuilder otherCharacters = new StringBuilder();

        char[] ch = line.toCharArray();
        for (char c : ch) {
            typeCheck(digit, letter, otherCharacters, c);
        }

        outputResult(digit, letter, otherCharacters);
    }

    private static void typeCheck(StringBuilder digit, StringBuilder letter, StringBuilder otherCharacters, char c) {
        if (Character.isDigit(c)) {
            digit.append(c);
        } else if (Character.isLetter(c)) {
            letter.append(c);
        } else {
            otherCharacters.append(c);
        }
    }

    private static void outputResult(StringBuilder digit, StringBuilder letter, StringBuilder otherCharacters) {
        System.out.println(digit);
        System.out.println(letter);
        System.out.println(otherCharacters);
    }
}
