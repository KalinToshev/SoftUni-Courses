import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];

        int[][] matrix = new int[rows][cols];

        fillMatrix(scanner, rows, cols, matrix);

        int r= matrix.length - 1;
        int c = matrix[0].length - 1;

        for (int i = 0; i < rows + cols - 1; i++) {
            printDiagonal(r, c, matrix);
            c--;
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, int rows, int cols, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = input[col];
            }
        }
    }

    private static void printDiagonal(int row, int col, int[][] matrix) {
        while(row >=0  && col < matrix[0].length) {
            if (isValid(row, matrix.length) && isValid(col, matrix[0].length)) {
                System.out.print(matrix[row][col] + " ");
            }
            row--;
            col++;
        }
    }

    private static boolean isValid(int i, int length) {
        return i >= 0 && i < length;
    }
}
