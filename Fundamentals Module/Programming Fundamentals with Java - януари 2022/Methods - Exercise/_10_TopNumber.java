package bg.softuni.MethodsExercise;

import java.util.Scanner;

public class _10_TopNumber {
    public static void main(String[] args) {
        //Create a scanner
        Scanner scanner = new Scanner(System.in);
        //Read an integer (n) from the console
        int n = Integer.parseInt(scanner.nextLine());
        //Loop from 1...n to find all top numbers
        for (int i = 1; i <= n; i++) {
            validateIfANumberIsATopNumber(i);
        }
    }
    static void validateIfANumberIsATopNumber(int number) {
        //Create a local variable to hold the current number
        int currentNum = number;
        int printRealNum = currentNum;
        //Create a sum variable to sum the digits of the current number
        int sumDigits = 0;
        //Make a while loop to sum the digits
        while (currentNum > 0) {
            //Create a variable to hold the current digit
            int currentDigit = currentNum % 10;
            //Sum the current digit
            sumDigits += currentDigit;
            //Remove the digit from the current number
            currentNum /= 10;
        }
        currentNum = number;
        //Make a while loop to check if the number has at least one odd digit
        while (currentNum > 0) {
            //Create a variable to hold the current digit
            int currentDigit = currentNum % 10;
            //Check if the current digit is odd
            if (currentDigit % 2 == 1) {
                if (sumDigits % 8 == 0) {
                    //Output the result
                   System.out.println(printRealNum);
                   break;
                }
            }
            //Remove the digit from the current number
            currentNum /= 10;
        }
    }
}
