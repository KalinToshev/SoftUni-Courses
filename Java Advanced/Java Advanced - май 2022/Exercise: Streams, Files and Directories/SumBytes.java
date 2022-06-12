import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Калин\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        long totalSum = 0;
        while (line != null) {
            long sum = 0;
            char[] chars = line.toCharArray();
            for (char c : chars) {
                sum += c;
            }
            totalSum += sum;
            line = bufferedReader.readLine();
        }
        System.out.println(totalSum);
    }
}
