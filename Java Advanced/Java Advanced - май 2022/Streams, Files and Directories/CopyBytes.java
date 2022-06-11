import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyBytes {
    public static void main(String[] args) {
        String path = "C:\\Users\\Калин\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream fileInputStream = new FileInputStream(path);
            FileOutputStream fileOutputStream = new FileOutputStream("output.txt");

            PrintWriter writer = new PrintWriter(fileOutputStream);

            int read = 0;
            while (-1 != (read = fileInputStream.read())) {
               if (read == ' ') {
                   writer.print(' ');
               } else if (read == 10) {
                   writer.println();
               } else {
                   writer.print(read);
               }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
