import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Прочитаме и запазваме броя на редовете и колоните
        int rowsAndCols = Integer.parseInt(scanner.nextLine());
        //Създаваме нашата 2Д матрица
        int[][] arr_2D = new int[rowsAndCols][rowsAndCols];
        //Пълним нашата матрица, като взимаме елементите от конзолата
        fillMatrix(scanner, rowsAndCols, arr_2D);
        //Създаваме алгоритъм за намираме на сумата на двата диагонала по условие
        int primaryDiagonalSum = 0;
        int secondaryDiagonalSum = 0;
        //Изчислияваме сумата на първия диагонал
        primaryDiagonalSum = getPrimaryDiagonalSum(rowsAndCols, arr_2D, primaryDiagonalSum);
        //Изчисляваме сумата на втория диагонал
        secondaryDiagonalSum = getSecondaryDiagonalSum(rowsAndCols, arr_2D, secondaryDiagonalSum);
        //Намираме разликарта между сумата на първия и сумата на втория диагонал
        //, като запазваме резултата като абсолютна стойност
        int finalResult = Math.abs(primaryDiagonalSum - secondaryDiagonalSum);
        //Принтираме резулатата на конзолата
        System.out.println(finalResult);
    }

    private static int getSecondaryDiagonalSum(int rowsAndCols, int[][] arr_2D, int secondaryDiagonalSum) {
        for (int i = 0; i < rowsAndCols; i++) {
            secondaryDiagonalSum += arr_2D[i][rowsAndCols - 1 - i];
        }
        return secondaryDiagonalSum;
    }

    private static int getPrimaryDiagonalSum(int rowsAndCols, int[][] arr_2D, int primaryDiagonalSum) {
        for (int i = 0; i < rowsAndCols; i++) {
            primaryDiagonalSum += arr_2D[i][i];
        }
        return primaryDiagonalSum;
    }

    private static void fillMatrix(Scanner scanner, int rowsAndCols, int[][] arr_2D) {
        for (int row = 0; row < rowsAndCols; row++) {
            int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < rowsAndCols; col++) {
                arr_2D[row][col] = input[col];
            }
        }
    }
}
