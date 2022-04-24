package bg.softuni.Data_Types_and_Variables_Lab;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        //Creating scanner to get input from the console
        Scanner scanner = new Scanner(System.in);
        /*Creating variable to store the input from the console,
        which input will be used for a range of numbers*/
        int n = Integer.parseInt(scanner.nextLine());
        //Creating a for loop to loop from 1...n
        for (int i = 1; i <= n; i++) {
            //Creating a variable that will hold the current number
            int currentNumber  = i;
            //Calculating the sum of digits of given number
            //Creating a sum variable to sum the digits of a given number
            int sum = 0;
            //Creating a while loop to get the digits of a given number and sum it
            while (currentNumber > 0) {
                sum += currentNumber % 10;
                currentNumber /= 10;
            }
            /*Creating an if-else construction to check
            if the sum is a special number or not*/
            if (sum == 5 || sum == 7 || sum == 11) {
                //Output 1
                System.out.println(i + " -> True");
            } else {
                //Output 2
                System.out.println(i + " -> False");
            }
        }
    }
}
