import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Цели за задачата: създаване и "пълнене" на един 2D Array
        //Цели за задачата: Прочитане на число от конзолата
        //Цели за задачата: Извличане на информация за позицията на даденото
        //число от конзолата, ако има като него в матрицата

        //Създаваме матрицата
        int[] rowsAndCols = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] arr_2D_One = new int[rowsAndCols[0]][rowsAndCols[1]];
        //"Пълним" матрицата
        for (int i = 0; i < rowsAndCols[0]; i++) {
            int[] colsElements = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < rowsAndCols[1]; j++) {
                arr_2D_One[i][j] = colsElements[j];
            }
        }

        //Прочитаме числото от конзолата
        int number = Integer.parseInt(scanner.nextLine());

        //Тъсим и принтираме позиците на числото, ако съществува в матрицата
        boolean isFound = false;
        for (int i = 0; i < rowsAndCols[0]; i++) {
            for (int j = 0; j < rowsAndCols[1]; j++) {
                if (arr_2D_One[i][j] == number) {
                    System.out.println(i + " " + j);
                    isFound = true;
                }
            }
        }
        //Ако не е намерено такова число в матрицата
        if (!isFound) {
            System.out.println("not found");
        }
    }
}
