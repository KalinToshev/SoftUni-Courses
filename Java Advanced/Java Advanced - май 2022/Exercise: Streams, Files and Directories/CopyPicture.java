import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyPicture {
    public static void main(String[] args) {
        byte[] buffer = new byte[1024];
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Калин\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\image.jpg");
            FileOutputStream fileOutputStream = new FileOutputStream("copyImage.jpg");
            while (fileInputStream.read(buffer) != -1) {
                fileOutputStream.write(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
