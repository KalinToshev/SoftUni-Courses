package bg.softuni.ObjectsАndClassesLab;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] words = sc.nextLine().split(" ");

        Random rnd = new Random();

        for (int pos1 = 0; pos1 < words.length; pos1++) {
            int pos2 = rnd.nextInt(words.length);

            String word1 = words[pos1];
            String word2 = words[pos2];

            changeWordsPositions(words, pos1, pos2, word1, word2);
        }

        System.out.println(String.join(System.lineSeparator(), words));
    }

    private static void changeWordsPositions(String[] words, int pos1, int pos2, String word1, String word2) {
        words[pos1] = word2;
        words[pos2] = word1;
    }
}
