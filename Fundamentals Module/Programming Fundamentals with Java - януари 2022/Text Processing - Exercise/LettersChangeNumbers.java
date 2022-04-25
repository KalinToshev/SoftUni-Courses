package bg.softuni.ExerciseTextProcessing;

import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split("\\s+");

        double totalResult = 0.0;

        for (String curSequence : data) {
            //Get the letters + number
            String[] token = curSequence.split("");
            char l11 = getL11(token);
            char l22 = getL22(token);
            StringBuilder n = new StringBuilder();
            double number = getNumber(token, n);

            //Get position in alphabet
            int pos1 = 0;
            int pos2 = 0;
            pos1 = getPos1(l11, pos1);
            pos2 = getPos2(l22, pos2);

            number = calculateResult(l11, l22, number, pos1, pos2);

            totalResult += number;
        }
        System.out.printf("%.2f", totalResult);
    }

    private static double getNumber(String[] token, StringBuilder n) {
        for (int j = 1; j < token.length - 1; j++) {
            n.append(token[j]);
        }
        return Double.parseDouble(String.valueOf(n));
    }

    private static char getL22(String[] token) {
        String l2 = token[token.length - 1];
        return l2.charAt(0);
    }

    private static char getL11(String[] token) {
        String l1 = token[0];
        return l1.charAt(0);
    }

    private static int getPos2(char l22, int pos2) {
        if (l22 >= 65 && l22 <= 90) {
            pos2 = l22 - 64;
        } else if (l22 >= 97 && l22 <= 122) {
            pos2 = l22 - 96;
        }
        return pos2;
    }

    private static int getPos1(char l11, int pos1) {
        if (l11 >= 65 && l11 <= 90) {
            pos1 = l11 - 64;
        } else if (l11 >= 97 && l11 <= 122) {
            pos1 = l11 - 96;
        }
        return pos1;
    }

    private static double calculateResult(char l11, char l22, double number, int pos1, int pos2) {
        //First letter operations
        if (l11 >= 65 && l11 <= 90) {
            //Uppercase
            number /= pos1;
        } else if (l11 >= 97 && l11 <= 122) {
            //Lowercase
            number *= pos1;
        }

        //Second letter operations
        if (l22 >= 65 && l22 <= 90) {
            //Uppercase
            number -= pos2;
        } else if (l22 >= 97 && l22 <= 122) {
            //Lowercase
            number += pos2;
        }
        return number;
    }
}
