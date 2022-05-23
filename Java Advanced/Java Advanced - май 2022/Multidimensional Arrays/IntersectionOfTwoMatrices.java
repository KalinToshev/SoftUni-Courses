import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Създаваме и "пълним" нашите 2 на брой 2Д матрици
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        String[][] arr_2D_One = new String[rows][cols];
        String[][] arr_2D_Two = new String[rows][cols];

        fillMatrices(scanner, rows, cols, arr_2D_One, arr_2D_Two);

        outputMatrices(rows, cols, arr_2D_One, arr_2D_Two);
    }

    private static void fillMatrices(Scanner scanner, int rows, int cols, String[][] arr_2D_One, String[][] arr_2D_Two) {
        for (int i = 0; i < rows; i++) {
            String[] colsElements = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                arr_2D_One[i][j] = colsElements[j];
            }
        }

        for (int i = 0; i < rows; i++) {
            String[] colsElements = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                arr_2D_Two[i][j] = colsElements[j];
            }
        }
    }

    private static void outputMatrices(int rows, int cols, String[][] arr_2D_One, String[][] arr_2D_Two) {
        //Правим проверки за всички елементи на еднкавки позиции от матриците и изпълняваме указанията
        //Редовете винаги ще бъдат еднакви на брой
        //Броя на колоните винаги ще бъдат еднакви на брой
        //Броя на елементите винаги ще бъде еднакъв
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr_2D_One[i][j].equals(arr_2D_Two[i][j])) {
                    System.out.printf("%s ", arr_2D_One[i][j]);
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
