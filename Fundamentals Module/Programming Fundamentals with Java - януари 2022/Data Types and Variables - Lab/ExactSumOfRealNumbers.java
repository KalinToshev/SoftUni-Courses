package bg.softuni.Data_Types_and_Variables_Lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Create a variable which provides how many times the for loop is gonna to loop
        int n = Integer.parseInt(scanner.nextLine());
        //Creating a BigDecimal variable, which is used for the calculations
        BigDecimal sum = new BigDecimal(0);
        //Running the loop
        for (int i = 0; i < n; i++) {
            //Creating new BigDecimal variable to get from the console the numbers
            BigDecimal number = new BigDecimal(scanner.nextLine());
            //Adding every number from the console to the *sum* variable
            sum = sum.add(number);
        }
        //Printing the *sum* value
        System.out.println(sum);
    }
}
