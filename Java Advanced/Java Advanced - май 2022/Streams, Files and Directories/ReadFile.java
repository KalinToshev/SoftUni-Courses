import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        String path = "C:\\Users\\Калин\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            int read = 0;
            while (-1 != (read = fileInputStream.read())) {
                System.out.printf("%s ", Integer.toBinaryString(read));
            }
        } catch (IOException ignore) {
        }
    }
}
