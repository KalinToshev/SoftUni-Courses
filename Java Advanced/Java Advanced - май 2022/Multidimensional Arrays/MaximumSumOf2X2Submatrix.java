import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2X2Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Прочитаме редоведете и колоните от конзолата
        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        //Създаваме матрицата
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        int[][] arr_2D = new int[rows][cols];
        //"Пълним" матрицата
        for (int row = 0; row < rows; row++) {
            //Прочитаме числата, които ще бъдат в матрицата от конзолата и ги запазваме
            arr_2D[row] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }

        //Намираме най-голямата 2Х2 подматрица и принтираме нейните елементи и сбора на стойностите ѝ
        int maxSum = Integer.MIN_VALUE;
        int[][] result = new int[2][2];
        for (int row = 0; row < rows - 1; row++) {
            for (int col = 0; col < cols - 1; col++) {
                int currentSum = arr_2D[row][col]
                        + arr_2D[row][col + 1]
                        + arr_2D[row + 1][col]
                        + arr_2D[row + 1][col + 1];
                if (maxSum < currentSum) {
                    maxSum = currentSum;
                    result = new int[][] {
                            {arr_2D[row][col],arr_2D[row][col + 1]},
                            {arr_2D[row + 1][col],arr_2D[row + 1][col + 1]}
                    };
                }
            }
        }

        //output
        output(maxSum, result);
    }

    private static void output(int maxSum, int[][] result) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);
    }
}
