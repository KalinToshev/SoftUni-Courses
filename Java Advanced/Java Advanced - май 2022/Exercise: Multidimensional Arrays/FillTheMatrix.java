import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Прочитаме от конзолата броя на редовете и колоните, както и начина, по който ще напълним нашата матрица
        String[] info = scanner.nextLine().split(", ");
        int rowsAndCols = Integer.parseInt(info[0]);
        String fillPattern = info[1];
        //След като сме прочели начина, по който ще напълним нашата матрица
        //създаваме и "пълниим" нашата матрица
        //Елементите, които ще се пазят в матрицата са от 1 до rowsAndCols * rowsAndCols
        int[][] arr_2D = new int[rowsAndCols][rowsAndCols];
        switch (fillPattern) {
            case "A":
                firstPattern(rowsAndCols, arr_2D);
                break;
            case "B":
                secondPattern(rowsAndCols, arr_2D);
                break;
        }
        //Принтираме матрицата на конзолата
        outputMatrix(rowsAndCols, arr_2D);
    }

    private static void outputMatrix(int rowsAndCols, int[][] arr_2D) {
        for (int i = 0; i < rowsAndCols; i++) {
            for (int j = 0; j < rowsAndCols; j++) {
                System.out.printf("%d ", arr_2D[i][j]);
            }
            System.out.println();
        }
    }

    private static void secondPattern(int rowsAndCols, int[][] arr_2D) {
        //ВТОРИ НАЧИН: ОТГОРЕ НАДОЛУ И ОБРАТНО
        boolean upToDown = true;
        int numbers = 1;
        for (int i = 0; i < rowsAndCols; i++) {
            if (upToDown) {
                for (int j = 0; j < rowsAndCols; j++) {
                    arr_2D[j][i] = numbers;
                    numbers++;
                }
                upToDown = false;
            } else  {
                for (int j = rowsAndCols - 1; j >= 0; j--) {
                    arr_2D[j][i] = numbers;
                    numbers++;
                }
                upToDown = true;
            }
        }
    }

    private static void firstPattern(int rowsAndCols, int[][] arr_2D) {
        //ПЪРВИ НАЧИН: ОТГОРЕ НАДОЛУ
        int numbers = 1;
        for (int i = 0; i < rowsAndCols; i++) {
            for (int j = 0; j < rowsAndCols; j++) {
                arr_2D[j][i] = numbers;
                numbers++;
            }
        }
    }
}
