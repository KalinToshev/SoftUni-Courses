package bg.softuni.Exercise_Data__Types_and__Variables;

import java.util.Scanner;

public class Integer_Operations_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        int numOne = Integer.parseInt(scanner.nextLine());
        int numTwo = Integer.parseInt(scanner.nextLine());
        int numThree = Integer.parseInt(scanner.nextLine());
        int numFour = Integer.parseInt(scanner.nextLine());
        //Calculate
        int result = ((numOne + numTwo) / numThree) * numFour;
        //Output
        System.out.println(result);
    }
}
