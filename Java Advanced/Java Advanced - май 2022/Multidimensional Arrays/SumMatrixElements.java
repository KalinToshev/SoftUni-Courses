import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        //
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        //

        //Създаваме и "пълним" 2Д матрицата
        int[][] arr_2D = new int[rows][cols];
        fillMatrix(scanner, rows, cols, arr_2D);

        //Изпълняваме метод за изчисление на сбора на всички елементи в матрицата
        int totalElementsSum = sum(rows, cols, arr_2D);
        //Отпечаваме всичко нужно на конзолата
        output(rows, cols, totalElementsSum);
    }

    private static void fillMatrix(Scanner scanner, int rows, int cols, int[][] arr_2D) {
        for (int i = 0; i < rows; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < cols; j++) {
                arr_2D[i][j] = numbers[j];
            }
        }
    }

    private static void output(int rows, int cols, int totalElementsSum) {
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(totalElementsSum);
    }

    private static int sum(int rows, int cols, int[][] arr_2D) {
        int totalElementsSum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                totalElementsSum += arr_2D[i][j];
            }
        }
        return totalElementsSum;
    }
}
