package bg.softuni.Data_Types_and_Variables_Lab;

import java.util.Scanner;

public class ConcatNames {
    public static void main(String[] args) {
        //Creating scanner to get input from the console
        Scanner scanner = new Scanner(System.in);
        //Creating 3 variables which will gonna hold the given value from the input
        String firstName = scanner.nextLine();
        String secondName = scanner.nextLine();
        String delimiter = scanner.nextLine();
        //Output
        System.out.printf("%s%s%s", firstName, delimiter, secondName);
    }
}
