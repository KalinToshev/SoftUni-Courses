package bg.softuni.Exercise_Data__Types_and__Variables;

import java.util.Scanner;

public class Beer_Kegs_08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //input
        int beerKegs = Integer.parseInt(scanner.nextLine());
        String model;
        double radius;
        int height;
        double max = 0;
        String biggest = "";
        //Calculate
        //Formula -> Math.PI * Math.pow(radius, 2) * height
        for (int i = 1; i <= beerKegs; i++) {
            model = scanner.nextLine();
            radius = Double.parseDouble(scanner.nextLine());
            height = Integer.parseInt(scanner.nextLine());
            double volume = Math.PI * Math.pow(radius, 2) * height;
            if (volume > max) {
                max = volume;
                biggest = model;
            }
        }
        System.out.println(biggest);
    }
}
