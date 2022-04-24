package bg.softuni.Data_Types_and_Variables_Lab;

import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        //Creating scanner to get input from the console
        Scanner scanner = new Scanner(System.in);
        //Creating a variable to hold the given input from the console
        char chr = scanner.next().charAt(0);
        //Making a if else statement to check if a given char is upper or lower case
        if (Character.isUpperCase(chr)) {
            //Output 1
            System.out.println("upper-case");
        } else {
            //Output 2
            System.out.println("lower-case");
        }
    }
}
