package bg.softuni.Data_Types_and_Variables_Lab;

import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        int distanceInMeters = Integer.parseInt(scanner.nextLine());
        //Output
        System.out.printf("%.2f", (double) distanceInMeters / 1000);
    }
}
