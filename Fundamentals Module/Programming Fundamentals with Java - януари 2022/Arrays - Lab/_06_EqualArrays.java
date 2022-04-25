package bg.softuni.ArraysLab;

import java.util.Arrays;
import java.util.Scanner;

public class _06_EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Read two int type arrays from the console
        int[] arrOne = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        int[] arrTwo = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        //Make max length variable
        int maxLength = 99999;
        //Create variable to sum the numbers of the first and second array
        int sumOne = 0;
        int sumTwo = 0;
        //Using for loop to loop through the elements of the first and second arrays
        for (int i = 0; i < arrOne.length; i++) {
            //Sum all elements of the first array
            sumOne += arrOne[i];
            sumTwo += arrTwo[i];
            //Check if arrOne[i] is not the same as arrTwo[i]
            if (arrOne[i] != arrTwo[i]) {
                //Output 1
                System.out.printf("Arrays are not identical. Found difference at %d index.", i);
                break;
            }
        }
        //Check if arrOne is the same as arrTwo
        if (sumOne == sumTwo) {
            //Output 2
            System.out.printf("Arrays are identical. Sum: %d", sumOne);
        }
    }
}

