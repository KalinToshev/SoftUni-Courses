import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Прочитаме и запазваме размера на матрицата от конзолата
        String[] matrixSize = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(matrixSize[0]);
        int cols = Integer.parseInt(matrixSize[1]);
        //Създаваме нашата 2Д матрица
        int[][] arr_2D = new int[rows][cols];
        //"Пълним" нашата матрица, като взимаме елементите от конзолата
        for (int row = 0; row < rows; row++) {
            arr_2D[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        //Създаваме алгоритъм за намиране на най-голяма 3Х3 подматрица
        int maxSum = Integer.MIN_VALUE;
        int bestStartingRow = -1;
        int bestStartingCol = -1;

        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = arr_2D[row][col] + arr_2D[row][col + 1] + arr_2D[row][col + 2]
                        + arr_2D[row + 1][col] + arr_2D[row + 1][col + 1] + arr_2D[row + 1][col + 2]
                        + arr_2D[row + 2][col] + arr_2D[row + 2][col + 1] + arr_2D[row + 2][col + 2];
                if (sum > maxSum) {
                    maxSum = sum;
                    bestStartingRow = row;
                    bestStartingCol = col;
                }
            }
        }
        
        //Принтираме нашата най-добра 3Х3 подматрица
        System.out.printf("Sum = %d%n", maxSum);
        for (int row = bestStartingRow; row < bestStartingRow + 3; row++) {
            for (int col = bestStartingCol; col < bestStartingCol + 3; col++) {
                System.out.print(arr_2D[row][col] + " ");
            }
            System.out.println();
        }
    }
}
