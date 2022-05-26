import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Прочитаме си входа от конзолата
        //Прочитаме командата с която ще въртим
        String rotationInput = scanner.nextLine();
        //Създаваме и "пълним" нашата матрица с поредица от думи, взети от конзолата
        String input = scanner.nextLine();

        int maxColumnLength = Integer.MIN_VALUE;

        List<String> wordsList = new ArrayList<>();

        while (!input.equals("END")) {

            //За да разберем броя на редовете и колоните
            //ще запазим всички думи в List
            //след това за брой на колоните ще вземе думата с най-голяма дължина
            //а броя на думите ще бъден равен и на броя на редовете на нашата матрица

            int currentLength = input.length();
            if (currentLength > maxColumnLength) {
                maxColumnLength = currentLength;
            }

            wordsList.add(input);

            input = scanner.nextLine();
        }

        int rows = wordsList.size();
        int cols = maxColumnLength;

        char[][] arr_2D = new char[rows][cols];

        fillMatrix(wordsList, rows, cols, arr_2D);

        //Създаване на алгоритъм за ротацията и принтирането на матрицата

        //Извличаме си ъгъла
        String angleString = rotationInput.split("[()]")[1];
        int angle = Integer.parseInt(angleString);

        //Намираме същинския ъгъл, по който ще правим проверка
        int angleOfRotation = angle % 360;

        //Принтиране на матрицата спрямо получения градус
        printMatrix(arr_2D, rows, cols, angleOfRotation);

    }

    private static void printMatrix(char[][] arr_2D, int rows, int cols, int angleOfRotation) {
        switch (angleOfRotation) {
            case 0:
                //При този случай не въртим матрицата
                for (int row = 0; row < rows; row++) {
                    for (int col = 0; col < cols; col++) {
                        System.out.print(arr_2D[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 90:
                //При този случай въртим надясно матрицата
                for (int col = 0; col < cols; col++) {
                    for (int row = rows - 1; row >= 0; row--) {
                        System.out.print(arr_2D[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 180:
                //При този случай завъртаме наобратно матрицата
                for (int row = rows - 1; row >= 0; row--) {
                    for (int col = cols - 1; col >= 0; col--) {
                        System.out.print(arr_2D[row][col]);
                    }
                    System.out.println();
                }
                break;
            case 270:
                //При този случай завъртаме наляво матрицата
                for (int col = cols - 1; col >= 0; col--) {
                    for (int row = 0;row  <  rows; row++) {
                        System.out.print(arr_2D[row][col]);
                    }
                    System.out.println();
                }
                break;
        }
    }

    private static void fillMatrix(List<String> wordsList, int rows, int cols, char[][] arr_2D) {
        for (int row = 0; row < rows; row++) {
            String currentWord = wordsList.get(row);
            for (int col = 0; col < cols; col++) {
                if (col < currentWord.length()) {
                    char currentChar = currentWord.charAt(col);
                    arr_2D[row][col] = currentChar;
                } else {
                    arr_2D[row][col] = ' ';
                }
            }
        }
    }
}
