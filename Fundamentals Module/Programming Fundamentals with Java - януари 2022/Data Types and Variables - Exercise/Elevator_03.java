package bg.softuni.Exercise_Data__Types_and__Variables;

import java.util.Scanner;

public class Elevator_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        int n = Integer.parseInt(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());
        //Calculating
        double courses = Math.ceil((double)n / p);
        //Output
        System.out.printf("%.0f", courses);
    }
}
