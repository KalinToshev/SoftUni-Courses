import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class WriteToFile {
    public static void main(String[] args) {

        List<Character> skip = List.of(',', '.', '!', '?');

        String path = "C:\\Users\\Калин\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
            int read = 0;
            while (-1 != (read = fileInputStream.read())) {
                if (!skip.contains((char) read)) {
                    fileOutputStream.write((char)read);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
