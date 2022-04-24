package bg.softuni.Exercise_Data__Types_and__Variables;

import java.util.Scanner;

public class Spice_Must_Flow_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        int startingYield = Integer.parseInt(scanner.nextLine());
        int daysCounter = 0;
        int leavingSum = 0;
        //Calculate
        while (startingYield>0) {
            if (startingYield < 100) {
                if (leavingSum < 26) {
                    break;
                }
                leavingSum -= 26;
                break;
            }
            leavingSum += startingYield - 26;
            startingYield -= 10;
            daysCounter++;
        }
        //Output
        System.out.println(daysCounter);
        System.out.println(leavingSum);
    }
}
