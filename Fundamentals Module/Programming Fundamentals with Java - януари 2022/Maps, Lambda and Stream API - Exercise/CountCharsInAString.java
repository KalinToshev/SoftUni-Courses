package bg.softuni.MapsLambdaAndStreamAPIExercise;

import java.util.*;
import java.util.stream.Collectors;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Create list of words given from the console and split them by space (" ")
        List<String> words = Arrays.stream(scanner.nextLine().split("" + " ")).collect(Collectors.toList());

        //Create a variable to concatenate every word from the list
        String concatenateWords = "";

        concatenateWords = concatenate(words, concatenateWords);

        words = refill(concatenateWords);

        //Create a Map to track the count of every letter
        Map<String, Integer> countCharacters = new LinkedHashMap<>();

        mapFill(words, countCharacters);

        outputResult(countCharacters);
    }

    private static void outputResult(Map<String, Integer> countCharacters) {
        //Print in the given format from the document
        for (Map.Entry<String, Integer> entry : countCharacters.entrySet()) {
            System.out.print(entry.getKey() + " -> " + entry.getValue());
            System.out.println();
        }
    }

    private static void mapFill(List<String> words, Map<String, Integer> countCharacters) {
        //Check if the given letter exists. If it exists: +1, if it does not exist we create a key and value 1
        for (String letter : words) {
            if (!countCharacters.containsKey(letter)) {
                countCharacters.put(letter, 1);
            } else {
                countCharacters.put(letter, countCharacters.get(letter) + 1);
            }
        }
    }

    private static List<String> refill(String concatenateWords) {
        List<String> words;
        //Rewriting the list and fill it with letters from the words
        words = Arrays.stream(concatenateWords.split("")).collect(Collectors.toList());
        return words;
    }

    private static String concatenate(List<String> words, String concatenateWords) {
        //Iterate through every word from the list and concatenate
        for (String word : words) {
            concatenateWords += word;
        }
        return concatenateWords;
    }
}