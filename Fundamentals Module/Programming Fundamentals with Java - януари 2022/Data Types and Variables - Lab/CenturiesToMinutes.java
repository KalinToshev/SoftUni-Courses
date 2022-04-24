package bg.softuni.Data_Types_and_Variables_Lab;

import java.util.Scanner;

public class CenturiesToMinutes {
    public static void main(String[] args) {
        //Creating scanner to get input from the console
        Scanner scanner = new Scanner(System.in);
        //Creating a variable in which the input from the console will be kept
        int centuries = Integer.parseInt(scanner.nextLine());
        //Creating a variables to convert to years, days, hours, and minutes
        double years = centuries * 100;
        double days = years * 365.2422;
        double hours = days * 24;
        double minutes = hours * 60;
        //Output
        System.out.printf("%d centuries = %.0f years = %.0f days = %.0f hours = %.0f minutes",
                centuries,
                years,
                days,
                hours,
                minutes);
    }
}
