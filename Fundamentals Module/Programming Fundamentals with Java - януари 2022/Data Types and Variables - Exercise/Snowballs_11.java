package bg.softuni.Exercise_Data__Types_and__Variables;

import java.util.Scanner;

public class Snowballs_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        int numberOfSnowballs = Integer.parseInt(scanner.nextLine());
        int snowballSnow;
        int snowballTime;
        int snowballQuality;
        double snowballValue;
        double highestSnowballValue = 0;
        int highestSnowballSnow = 0;
        int highestSnowballTime = 0;
        int highestSnowballQuality = 0;
        //Calculate
        for (int i = 1; i <= numberOfSnowballs; i++) {
            snowballSnow = Integer.parseInt(scanner.nextLine());
            snowballTime = Integer.parseInt(scanner.nextLine());
            snowballQuality = Integer.parseInt(scanner.nextLine());
            snowballValue = Math.pow(((double) snowballSnow / snowballTime), snowballQuality);
            if (snowballValue > highestSnowballValue) {
                highestSnowballValue = snowballValue;
                highestSnowballSnow = snowballSnow;
                highestSnowballTime = snowballTime;
                highestSnowballQuality = snowballQuality;
            }
        }
        //output
        System.out.printf("%.0f : %.0f = %.0f (%.0f)", (double)  highestSnowballSnow, (double)  highestSnowballTime, highestSnowballValue, (double) highestSnowballQuality);
    }
}
