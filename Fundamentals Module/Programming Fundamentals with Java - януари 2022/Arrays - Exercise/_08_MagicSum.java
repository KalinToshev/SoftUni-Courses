package bg.softuni.ArraysExercise;

import java.util.Arrays;
import java.util.Scanner;

public class _08_MagicSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int uniqueNumber = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j <= arr.length - 1; j++) {
                if (arr[i] + arr[j] == uniqueNumber) {
                    System.out.println(arr[i] + " " + arr[j]);
                }
            }
        }
    }
}
