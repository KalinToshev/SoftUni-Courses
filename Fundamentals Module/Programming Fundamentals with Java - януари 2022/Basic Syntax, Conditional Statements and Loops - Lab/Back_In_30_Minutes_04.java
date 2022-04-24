package bg.softuni.Basic_Syntax_Conditional_Statements_and_Loops;

import java.util.Scanner;

public class Back_In_30_Minutes_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Input
        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        //Calculating
        minutes += 30;
        if (minutes > 60) {
            minutes -= 60;
            hours++;
        }
        if (hours > 23) {
            hours -= 24;
        }

        //Output
        System.out.printf("%d:%02d", hours, minutes);
    }
}
