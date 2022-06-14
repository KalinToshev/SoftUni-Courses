import java.io.*;

public class AllCapitals {
    public static void main(String[] args) {
        String path = "C:\\Users\\Калин\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path));) {
            PrintWriter printWriter = new PrintWriter(new FileWriter("C:\\Users\\Калин\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt"));
            bufferedReader.lines().forEach(line -> printWriter.println(line.toUpperCase()));
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
