import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\Калин\\Desktop\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = "";
        long totalSum = 0;
        while (null != (line = bufferedReader.readLine())) {
            long sum = 0;
            char[] chars = line.toCharArray();
            for (char c : chars) {
                sum += c;
            }
            totalSum += sum;
        }
        System.out.println(totalSum);
        bufferedReader.close();
    }
}
