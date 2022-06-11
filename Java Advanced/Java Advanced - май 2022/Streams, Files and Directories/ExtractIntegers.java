import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) {
        String path = "C:\\Users\\Калин\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

            Scanner scanner = new Scanner(fileInputStream);

            PrintWriter writer = new PrintWriter(fileOutputStream);

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    writer.println(scanner.next());
                } else {
                    scanner.next();
                }
            }

            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
