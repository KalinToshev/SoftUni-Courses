package bg.softuni.Exercise_Data__Types_and__Variables;

import java.util.Scanner;

public class Water_Overflow_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        int n = Integer.parseInt(scanner.nextLine());
        int tank = 0;
        //Compute
        for (int i = 0; i < n; i++) {
            int load = Integer.parseInt(scanner.nextLine());
            if (tank + load <= 255) {
                tank += load;
            } else {
                System.out.println("Insufficient capacity!");
            }
        }
        //output
        System.out.println(tank);
    }
}
