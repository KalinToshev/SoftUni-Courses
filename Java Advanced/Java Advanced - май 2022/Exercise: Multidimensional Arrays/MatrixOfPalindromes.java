import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Прочитаме входа от конзолата
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        //Запазваме броя на редовете и колоните
        int rows = input[0];
        int cols = input[1];
        //Създаваме нашата 2Д матрица
        String[][] arr_2D = new String[rows][cols];
        //Попълваме нашата матрица по даденото ни условие
        fillMatrix(rows, cols, arr_2D);
        //Принтираме матрицата
        outputMatrix(rows, cols, arr_2D);
    }

    private static void outputMatrix(int rows, int cols, String[][] arr_2D) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.printf("%s ", arr_2D[row][col]);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(int rows, int cols, String[][] arr_2D) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                //Тук трябва да се съобрази какъв ще бъде вътрешния и външния символ
                char outside = (char) ('a' + row);
                char middle = (char) (outside + col);
                arr_2D[row][col] = "" + outside + middle + outside;
            }
        }
    }
}
