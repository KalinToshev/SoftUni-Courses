package bg.softuni.MapsLambdaAndStreamAPILab;

import java.util.*;

public class WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Read lines of words
        int lines = Integer.parseInt(scanner.nextLine());

        //Create Map list <Word, Synonyms of the word>
        Map<String, List<String>> wordAndSynonyms = new LinkedHashMap<>();

        //Iterate through lines var
        for (int i = 0; i < lines; i++) {
            //Read word + synonym
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            //Create String[] + add word and synonym to it
            String[] tokens = new String[2];
            tokens[0] = word;
            tokens[1] = synonym;

            addWordOrSynonyms(wordAndSynonyms, synonym, tokens);
        }

        //Loop through every key and print him and his values
        for (Map.Entry<String, List<String>> stringListEntry : wordAndSynonyms.entrySet()) {
            printKey(stringListEntry);

            //Get size of every value list
            int size = stringListEntry.getValue().size();

            printKeyValues(stringListEntry, size);

            lineBreaker();
        }
    }

    private static void addWordOrSynonyms(Map<String, List<String>> wordAndSynonyms, String synonym, String[] tokens) {
        //Check if given word exist in Map list or not
        if (!wordAndSynonyms.containsKey(tokens[0])) {
            //If word not exist add her to Map list and her synonym
            wordAndSynonyms.put(tokens[0], new ArrayList<>());
            wordAndSynonyms.get(tokens[0]).add(synonym);
        } else {
            //If word exist add only her synonym
            wordAndSynonyms.get(tokens[0]).add(synonym);
        }
    }

    private static void printKey(Map.Entry<String, List<String>> stringListEntry) {
        //Print key of Map list
        System.out.print(stringListEntry.getKey() + " - ");
    }

    private static void printKeyValues(Map.Entry<String, List<String>> stringListEntry, int size) {
        //Loop the size
        for (int i = 0; i < size; i++) {
            //Print values
            if (i != size - 1) {
                System.out.print(stringListEntry.getValue().get(i) + ", ");
            } else {
                System.out.print(stringListEntry.getValue().get(i));
            }
        }
    }

    private static void lineBreaker() {
        //Break line
        System.out.println();
    }
}
