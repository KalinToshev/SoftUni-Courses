import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Калин\\Desktop\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output.txt"));

        int counter = 0;
        String line = bufferedReader.readLine();
        while (line != null) {
            counter++;

            if (counter % 3 == 0) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            line = bufferedReader.readLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}
