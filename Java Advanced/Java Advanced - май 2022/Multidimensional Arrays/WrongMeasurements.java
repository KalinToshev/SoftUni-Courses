import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        //Създаваме и "пълним" нашата матрица
        int rowsAndCols = Integer.parseInt(console.nextLine());
        int[][] arr_2D = new int[rowsAndCols][];

        fillMatrix(console, rowsAndCols, arr_2D);

        //Създаваме нова финална матрица
        int[][] arr_2D_final = new int[rowsAndCols][arr_2D[0].length];

        //Взимаме от конзолата позицията на грешния елемент и го запаметяваме
        String[] wrongValueRowAndColumn = console.nextLine().split("\\s+");
        int row = Integer.parseInt(wrongValueRowAndColumn[0]);
        int col = Integer.parseInt(wrongValueRowAndColumn[1]);
        int wrongValue = arr_2D[row][col];

        //Правим алгоритъм за изчисление на финалната правилна матрица
        calculateFinalMatrix(rowsAndCols, arr_2D, arr_2D_final, wrongValue);
        //Принтираме финалната матрица
        outputFinalMatrix(arr_2D_final);
    }

    private static void outputFinalMatrix(int[][] arr_2D_final) {
        System.out.println(Arrays.deepToString(arr_2D_final).replace("], ", "\n").replaceAll("[\\[\\],]", ""));
    }

    private static void calculateFinalMatrix(int rowsAndCols, int[][] arr_2D, int[][] arr_2D_final, int wrongValue) {
        for (int i = 0; i < rowsAndCols; i++) {
            for (int j = 0; j < arr_2D[i].length; j++) {
                if (arr_2D[i][j] == wrongValue) {
                    arr_2D_final[i][j] = ((j == 0 ? 0 : arr_2D[i][j - 1] == wrongValue ? 0 : arr_2D[i][j - 1]) +
                            (j == arr_2D[i].length - 1 ? 0 : arr_2D[i][j + 1] == wrongValue ? 0 : arr_2D[i][j + 1]) +
                            (i == 0 ? 0 : arr_2D[i - 1][j] == wrongValue ? 0 : arr_2D[i - 1][j]) +
                            (i == rowsAndCols - 1 ? 0 : arr_2D[i + 1][j] == wrongValue ? 0 : arr_2D[i + 1][j]));
                } else {
                    arr_2D_final[i][j] = arr_2D[i][j];
                }
            }
        }
    }

    private static void fillMatrix(Scanner console, int rowsAndCols, int[][] arr_2D) {
        for (int i = 0; i < rowsAndCols; i++) {
            arr_2D[i] = Arrays.stream(console.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }
}
