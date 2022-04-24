package bg.softuni.Exercise_Data__Types_and__Variables;

import java.util.Scanner;

public class Sum_Digits_02 {
    public static void main(String[] args) {
        //Creates scanner to reads input from the console
        Scanner scanner = new Scanner(System.in);
        //Input from console
        String number = scanner.nextLine();
        int num = Integer.parseInt(number);
        int sumOfDigits = 0;
        //Calculate under given condition
        for (int i = 1; i <= number.length(); i++) {
            int lastDigitFromGivenNumber = num % 10;
            sumOfDigits += lastDigitFromGivenNumber;
            num = num / 10;
        }
        //Output the result
        System.out.println(sumOfDigits);
    }
}
