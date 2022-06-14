import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String path = "C:\\Users\\Калин\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";

        int vowels = 0;
        int consonants = 0;
        int punctuation = 0;

        try {
            FileReader fileReader = new FileReader(path);
            PrintWriter printWriter = new PrintWriter("output.txt");

            int oneSymbol = fileReader.read();
            while (oneSymbol >= 0) {

                char symbolAsChar = (char) oneSymbol;
                if (isVowel(symbolAsChar)) {
                    vowels++;
                } else if (isPunctuation(symbolAsChar)) {
                    punctuation++;
                } else if (!Character.isWhitespace(symbolAsChar)) {
                    consonants++;
                }

                oneSymbol = fileReader.read();
            }

            printWriter.println("Vowels: " + vowels);
            printWriter.println("Consonants: " + consonants);
            printWriter.println("Punctuation: " + punctuation);

            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean isVowel(char character) {
        return character == 'a' || character == 'o' || character == 'u' || character == 'e' || character == 'i';
    }

    public static boolean isPunctuation(char character) {
        return character == '!' || character == ',' || character == '.' || character == '?';
    }
}
