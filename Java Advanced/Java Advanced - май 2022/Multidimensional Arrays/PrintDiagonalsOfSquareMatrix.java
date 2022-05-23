import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndCols = Integer.parseInt(scanner.nextLine());
        //Създаваме и "пълним" 2Д матрицата
        int[][] arr_2D = new int[rowsAndCols][rowsAndCols];
        fillMatrix(scanner, rowsAndCols, arr_2D);

        outputDiagonals(rowsAndCols, arr_2D);
    }

    private static void outputDiagonals(int rowsAndCols, int[][] arr_2D) {
        //Намираме и принтираме диагоналите, чрез два цикъла
        //Първи диагонал
        for (int i = 0; i < rowsAndCols; i++) {
            System.out.printf("%d ", arr_2D[i][i]);
        }
        System.out.println();
        //Втори диагонал
        int j = 0;
        for (int i = rowsAndCols - 1; i >= 0; i--) {
            System.out.printf("%d ", arr_2D[i][j]);
            j++;
        }
    }

    private static void fillMatrix(Scanner scanner, int rowsAndCols, int[][] arr_2D) {
        for (int i = 0; i < rowsAndCols; i++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < rowsAndCols; j++) {
                arr_2D[i][j] = numbers[j];
            }
        }
    }
}
