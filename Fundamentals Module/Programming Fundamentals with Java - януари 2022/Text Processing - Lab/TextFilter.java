package bg.softuni.TextProcessingLab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TextFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> banList = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        String text = scanner.nextLine();

        for (String word : banList) {
            String filler = "";
            filler = fillStars(word, filler);
            text = text.replace(word, filler);
        }
        outputResult(text);
    }

    private static void outputResult(String text) {
        System.out.println(text);
    }

    private static String fillStars(String word, String filler) {
        for (int i = 0; i < word.length(); i++) {
            filler += "*";
        }
        return filler;
    }
}
