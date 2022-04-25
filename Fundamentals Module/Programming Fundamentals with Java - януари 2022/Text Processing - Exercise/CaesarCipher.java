package bg.softuni.ExerciseTextProcessing;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        char[] ch = line.toCharArray();

        StringBuilder encryptedMessage = new StringBuilder();

        transformCharacters(ch, encryptedMessage);

        System.out.println(encryptedMessage);
    }

    private static void transformCharacters(char[] ch, StringBuilder encryptedMessage) {
        for (char character : ch) {
            char newCh = (char) (character + 3);
            encryptedMessage.append(newCh);
        }
    }
}
