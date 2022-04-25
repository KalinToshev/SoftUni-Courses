package bg.softuni.MapsLambdaAndStreamAPILab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lineOfWords = scanner.nextLine();

        String[] words = lineOfWords.split(" ");

        List<String> wordsWithEvenLength = Arrays.stream(words).filter(w -> w.length() % 2 == 0).collect(Collectors.toList());

        for (String s : wordsWithEvenLength) {
            System.out.println(s);
        }
    }
}
