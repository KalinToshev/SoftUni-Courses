package bg.softuni.MethodsLab;

import java.util.Scanner;

public class _09_GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        printBasedOnTheInput(scanner, input);

    }

    private static void printBasedOnTheInput(Scanner scanner, String input) {
        switch (input){
            case "int":
                int number1 = Integer.parseInt(scanner.nextLine());
                int number2 = Integer.parseInt(scanner.nextLine());
                System.out.println(getMax(number1, number2));
                break;
            case "char":
                char char1 = scanner.nextLine().charAt(0);
                char char2 = scanner.nextLine().charAt(0);
                System.out.println(getMax(char1, char2));
                break;
            case "string":
                String name1 = scanner.nextLine();
                String name2 = scanner.nextLine();
                System.out.println(getMax(name1, name2));
                break;
        }
    }

    static int getMax(int number1, int number2) {
        return Math.max(number1, number2);
    }

    static String getMax(String name1, String name2) {
        if (name1.compareTo(name2) >= 0) {
            return name1;
        }
        return name2;
    }

    static char getMax(char char1, char char2) {
        if ( char1 > char2) {
            return char1;
        }
        return char2;
    }
}
