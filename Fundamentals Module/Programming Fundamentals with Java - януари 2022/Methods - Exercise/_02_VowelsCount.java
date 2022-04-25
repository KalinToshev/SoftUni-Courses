package bg.softuni.MethodsExercise;

import java.util.Scanner;

public class _02_VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        countVowelsCharacters(word);
    }
    static void countVowelsCharacters(String word) {
        int vowelsCounter = 0;
        char[] stringCharacters = word.toCharArray();
        for (char stringCharacter : stringCharacters) {
            char ch = Character.toLowerCase(stringCharacter);
            if (ch == 'a'
            || ch == 'e'
            || ch == 'i'
            || ch == 'o'
            || ch == 'u') {
                vowelsCounter++;
            }
        }
        System.out.println(vowelsCounter);
    }
}
