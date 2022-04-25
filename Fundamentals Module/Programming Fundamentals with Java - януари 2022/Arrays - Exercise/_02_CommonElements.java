package bg.softuni.ArraysExercise;

import java.util.Scanner;

public class _02_CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Get input and set it into arrOne
        String[] arrOne = scanner.nextLine().split(" ");
        //Get input and set it into arrTwo
        String[] arrTwo = scanner.nextLine().split(" ");
        //Loop through all elements of arrTwo
        for (int i = 0; i < arrTwo.length; i++) {
            //Loop through all elements of arrOne
            for (int j = 0; j < arrOne.length; j++) {
                //Check if arrTwo element is equal to any of arrOne elements
                if (arrTwo[i].equals(arrOne[j])) {
                    //Print the equal element
                    System.out.print(arrTwo[i] + " ");
                }
            }
        }
    }
}
