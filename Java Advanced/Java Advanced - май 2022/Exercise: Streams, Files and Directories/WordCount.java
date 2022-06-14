import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) {
        String path1 = "C:\\Users\\Калин\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt";
        String path2 = "C:\\Users\\Калин\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt";
        try {
            LinkedHashMap<String, Integer> wordCount = new LinkedHashMap<>();

            PrintWriter printWriter = new PrintWriter("output.txt");

            Scanner scanner1 = new Scanner(new FileReader(path1));
            Scanner scanner2 = new Scanner(new FileReader(path2));
            Arrays.stream(scanner1.nextLine().split(" ")).forEach(word -> wordCount.put(word, 0));

            while (scanner2.hasNext()) {
                String textInput = scanner2.next();
                if (wordCount.containsKey(textInput)) {
                    int occurrences = wordCount.get(textInput);
                    occurrences++;
                    wordCount.put(textInput, occurrences);
                }
            }

            wordCount.forEach((k, v) -> {
                printWriter.println(k + " - " + v);
            });

            scanner1.close();
            scanner2.close();
            printWriter.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
