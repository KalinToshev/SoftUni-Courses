package bg.softuni.Data_Types_and_Variables_Lab;

import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        //Creating scanner to get input from the console
        Scanner scanner = new Scanner(System.in);
        //Creating 3 variables which will gonna hold the given value from the input
        char chrOne = scanner.next().charAt(0);
        char chrTwo = scanner.next().charAt(0);
        char chrThree = scanner.next().charAt(0);
        //Output
        System.out.println(chrOne + "" + chrTwo + chrThree);
    }
}
