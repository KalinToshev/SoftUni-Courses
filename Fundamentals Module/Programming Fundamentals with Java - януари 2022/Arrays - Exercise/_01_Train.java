package bg.softuni.ArraysExercise;

import java.util.Scanner;

public class _01_Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Get numbers of wagons
        int countOfWagons = Integer.parseInt(scanner.nextLine());
        //Create whoTrain arr and set length
        int[] wholeTrain = new int[countOfWagons];
        //Create sum var == all elements of wholeTrain arr
        int sum = 0;
        //Loop through all elements of wholeTrain arr
        for (int i = 0; i < countOfWagons; i++) {
            //Get number of people per wagon
            int numberOfPeople = Integer.parseInt(scanner.nextLine());
            //Set numberOfPeople to the correct wagon
            wholeTrain[i] = numberOfPeople;
            //Sum of all peoples at all wagons
            sum += wholeTrain[i];
            //Print the num of people per wagon
            System.out.print(wholeTrain[i] + " ");
        }
        //break line
        System.out.println();
        //Print sum of wholeTrain arr
        System.out.println(sum);
    }
}
