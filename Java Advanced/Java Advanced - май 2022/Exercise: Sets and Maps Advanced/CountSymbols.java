import java.util.*;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Character, Integer> occurrencesOfEachCharacter = new HashMap<>();

        char[] line = scanner.nextLine().toCharArray();

        fillTheMap(occurrencesOfEachCharacter, line);

        List<Character> sortedKeys = sortKeys(occurrencesOfEachCharacter);

        output(occurrencesOfEachCharacter, sortedKeys);
    }

    private static void output(Map<Character, Integer> occurrencesOfEachCharacter, List<Character> sortedKeys) {
        for(Character key : sortedKeys) {
            System.out.println(key + ": " + occurrencesOfEachCharacter.get(key) + " time/s");
        }
    }

    private static List<Character> sortKeys(Map<Character, Integer> occurrencesOfEachCharacter) {
        List<Character> sortedKeys = new ArrayList<>(occurrencesOfEachCharacter.keySet());

        Collections.sort(sortedKeys);
        return sortedKeys;
    }

    private static void fillTheMap(Map<Character, Integer> occurrencesOfEachCharacter, char[] line) {
        for (char c : line) {
            if (!occurrencesOfEachCharacter.containsKey(c)) {
                occurrencesOfEachCharacter.put(c, 1);
            } else {
                occurrencesOfEachCharacter.put(c, occurrencesOfEachCharacter.get(c) + 1);
            }
        }
    }
}
