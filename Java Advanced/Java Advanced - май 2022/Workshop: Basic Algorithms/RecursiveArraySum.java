package BasicAlgorithmsLab;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int arrIndex = arr.length - 1;
        int sum = findSum(arr, arrIndex);
        System.out.println(sum);
    }
    public static int findSum(int[] arr, int arrIndex) {
        if (arrIndex == 0) {
            return arr[arrIndex];
        } else {
            return arr[arrIndex] + findSum(arr, arrIndex - 1);
        }
    }
}
