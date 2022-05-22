import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Създаваме матриците
        //Матриците винаги ще са 2 на бр. и 2D (Data_type: int)

        //Създаваме и "пълним" първата матрица
        int[] rowsAndColsOne = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] arr_2D_One = new int[rowsAndColsOne[0]][rowsAndColsOne[1]];

        for (int i = 0; i < rowsAndColsOne[0]; i++) {
            int[] colsElements = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < rowsAndColsOne[1]; j++) {
                arr_2D_One[i][j] = colsElements[j];
            }
        }

        //Създаваме и "пълним" втората матрица
        int[] rowsAndColsTwo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[][] arr_2D_Two = new int[rowsAndColsTwo[0]][rowsAndColsTwo[1]];

        for (int i = 0; i < rowsAndColsTwo[0]; i++) {
            int[] colsElements = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < rowsAndColsTwo[1]; j++) {
                arr_2D_Two[i][j] = colsElements[j];
            }
        }

        //Прилагаме метод за сравнение
        boolean isEqual = compare(rowsAndColsOne, rowsAndColsTwo, arr_2D_One, arr_2D_Two);
        //Принтираме резултата
        if (isEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

    private static boolean compare(int[] rowsAndColsOne, int[] rowsAndColsTwo, int[][] arr_2D_one, int[][] arr_2D_two) {
        //Първо сравняваме по броя на колоните и редовете
        if (rowsAndColsOne[0] > rowsAndColsTwo[0]
                || rowsAndColsTwo[0] > rowsAndColsOne[0]
                || rowsAndColsOne[1] > rowsAndColsTwo[1]
                || rowsAndColsTwo[1] > rowsAndColsOne[1]) {
            return false;
        } else {
            //Ако влезе в else, значи ще сравняваме елементите
            for (int i = 0; i < rowsAndColsOne[0]; i++) {
                for (int j = 0; j < rowsAndColsOne[1]; j++) {
                    if (arr_2D_one[i][j] != arr_2D_two[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
