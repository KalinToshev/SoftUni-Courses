package bg.softuni.ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class _05_EvenAndOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Array with numbers (input from the console)
        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        //Variable for sum the even or odd num from the array
        int evenSum = 0;
        int oddSum = 0;
        //For loop to loop through every number in the array
        for (int i = 0; i < numbers.length; i++) {
            //Check even or odd
            if (numbers[i] % 2 == 0) {
                evenSum += numbers[i];
            } else {
                oddSum += numbers[i];
            }
        }
        //Variable holds the result of *evenSum - oddSum*
        int result = evenSum - oddSum;
        //Print the result
        System.out.printf("%d", result);
    }
}
