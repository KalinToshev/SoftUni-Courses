package bg.softuni.ArraysLab;

import java.util.Scanner;

public class _01_DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
        int dayNumber = Integer.parseInt(scanner.nextLine());
        if (dayNumber >= 1 && dayNumber <= 7) {
            System.out.println(days[dayNumber - 1]);
        } else {
            System.out.println("Invalid day!");
        }
    }
}
