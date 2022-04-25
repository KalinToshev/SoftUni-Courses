package bg.softuni.MapsLambdaAndStreamAPILab;

import java.util.*;
import java.util.stream.Collectors;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Read and save words from the console
        List<String> words = Arrays.stream(scanner.nextLine().split(" ")).collect(Collectors.toList());

        //Lowercase all words
        for (int i = 0; i < words.size(); i++) {
            words.add(words.remove(0).toLowerCase());
        }

        //Create Map list
        Map<String, Integer> oddNumberOfTimesElements = new LinkedHashMap<>();

        //Iterate through every word in the list
        for (String word : words) {
            //If the current word didn't exist as a key in the Map list
            if (!oddNumberOfTimesElements.containsKey(word)) {
                oddNumberOfTimesElements.put(word, 1);
            } else {
                //If the current word exist +1 its key value
                oddNumberOfTimesElements.put(word, oddNumberOfTimesElements.get(word) + 1);
            }
        }

        //If given key -> value is even, remove key
        //Create List to hold even keys values names
        List<String> getKeys = new ArrayList<>();
        String position = "";
        //Find even keys values and add them to teh list
        for (Map.Entry<String, Integer> entry : oddNumberOfTimesElements.entrySet()) {
            position = entry.getKey();
            if (entry.getValue() % 2 == 0) {
                getKeys.add(position);
            }
        }

        //remove even key values from the Map
        for (String getKey : getKeys) {
            oddNumberOfTimesElements.remove(getKey);
        }

        //Print keys statements
        int index = 0;
        for (Map.Entry<String, Integer> entry : oddNumberOfTimesElements.entrySet()) {
            int size = oddNumberOfTimesElements.size() - 1;
            if (index != size) {
                System.out.print(entry.getKey() + ", ");
            } else {
                System.out.print(entry.getKey());
            }
            index += 1;
        }
    }
}
