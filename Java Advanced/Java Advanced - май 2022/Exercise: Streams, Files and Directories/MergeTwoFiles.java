import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String path1 = "C:\\Users\\Калин\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt";
        String path2 = "C:\\Users\\Калин\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt";

        Path input1 = Paths.get(path1);
        Path input2 = Paths.get(path2);
        Path output = Paths.get("output.txt");

        List<String> firstFile = Files.readAllLines(input1);
        List<String> secondFile = Files.readAllLines(input2);

        Files.write(output, firstFile, StandardOpenOption.APPEND);
        Files.write(output, secondFile, StandardOpenOption.APPEND);

    }
}
