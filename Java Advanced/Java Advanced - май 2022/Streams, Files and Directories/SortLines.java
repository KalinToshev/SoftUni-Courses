import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class SortLines {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Калин\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        List<String> sortedLines = Files.readAllLines(Path.of(path))
                .stream()
                .sorted()
                .collect(Collectors.toList());
        Path outputPath = Path.of("output.txt");
        Files.write(outputPath, sortedLines);
    }
}
