import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Прочитаме си броя на редовете и колоните от конзолата и ги запазваме
        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = rowsAndCols[0];
        int cols = rowsAndCols[1];
        //Създаваме и "пълним" 2Д матрицата
        String[][] arr_2D = new String[rows][cols];
        fillMatrix(scanner, rows, arr_2D);
        //Изпълняваме само "swap" команда, докато не получим "END"
        String command;
        while (!"END".equals(command = scanner.nextLine())) {
            String[] tokens = command.split("\\s+");
            if (tokens.length != 5 || !tokens[0].equals("swap")) {
                System.out.println("Invalid input!");
                continue;
            }

            int row1 = Integer.parseInt(tokens[1]);
            int col1 = Integer.parseInt(tokens[2]);
            int row2 = Integer.parseInt(tokens[3]);
            int col2 = Integer.parseInt(tokens[4]);

            if (!indexIsValid(row1, rows) || !indexIsValid(col1, cols) || !indexIsValid(row2, rows) || !indexIsValid(col2, cols)) {
                System.out.println("Invalid input!");
                continue;
            }

            String tmp = arr_2D[row1][col1];
            arr_2D[row1][col1] = arr_2D[row2][col2];
            arr_2D[row2][col2] = tmp;

            outputMatrix(arr_2D);

//            if (tokens[0].equals("swap")) {
//                int row1 = Integer.parseInt(tokens[1]);
//                int col1 = Integer.parseInt(tokens[2]);
//                int row2 = Integer.parseInt(tokens[3]);
//                int col2 = Integer.parseInt(tokens[4]);
//
//                if (!indexIsValid(row1, rows) || !indexIsValid(col1, cols) || !indexIsValid(row2, rows) || !indexIsValid(col2, cols)) {
//                    System.out.println("Invalid input!");
//                    continue;
//                }
//
//                String firstElement = arr_2D[row1][col1];
//                String secondElement = arr_2D[row2][col2];
//                swapElements(arr_2D, row1, col1, row2, col2, firstElement, secondElement);
//                //След всяка успешна команда принтираме матрицата
//                outputMatrix(rows, cols, arr_2D);
//            } else {
//                System.out.println("Invalid input!");
//            }
        }
    }

    private static void outputMatrix(String[][] arr_2D) {
        for (int i = 0; i < arr_2D.length; i++) {
            for (int j = 0; j < arr_2D[i].length; j++) {
                System.out.print(arr_2D[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void fillMatrix(Scanner scanner, int rows, String[][] arr_2D) {
        for (int row = 0; row < rows; row++) {
            arr_2D[row] = scanner.nextLine().split("\\s+");
        }
    }

    private static boolean indexIsValid(int i, int max) {
        return i >= 0 && i < max;
    }
}
