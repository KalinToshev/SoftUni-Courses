import java.io.*;

public class LineNumbers {
    public static void main(String[] args) {
        String path = "C:\\Users\\Калин\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            PrintWriter printWriter = new PrintWriter("output.txt");
            int countLine = 1;
            String line = "";
            while (null != (line = bufferedReader.readLine())) {
                printWriter.println(countLine + ". " + line);
                countLine++;
            }
            printWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
