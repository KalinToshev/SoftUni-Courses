package bg.softuni.Data_Types_and_Variables_Lab;

import java.util.Scanner;

public class TownInfo {
    public static void main(String[] args) {
        //Creating scanner to get input from the console
        Scanner scanner = new Scanner(System.in);
        //Creating the variables, which will store the value inputted from the console
        String townName = scanner.nextLine();
        int population = Integer.parseInt(scanner.nextLine());
        int area = Integer.parseInt(scanner.nextLine());
        //Printing the given statement
        System.out.printf("Town %s has population of %d and area %d square km.", townName, population, area);
    }
}
