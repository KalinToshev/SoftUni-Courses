import java.util.Scanner;

public class Time_Plus_15_Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Създавам две променливи, които държат стойностите - часове и минути, въведени от потребителя
         int hours = Integer.parseInt(scanner.nextLine());
         int minutes = Integer.parseInt(scanner.nextLine());
         //Изчислявам колко ще бъде часа след 15 минути, спрямо времето въведено от потребителя
        int addedMinutes = minutes + 15;
        if (addedMinutes >= 60 ) {
            hours = hours + 1;
            addedMinutes = addedMinutes - 60;
        }
        if (hours > 23) {
            hours = hours - 24;
        }
        if (addedMinutes < 10) {
            System.out.printf("%d:0%d", hours, addedMinutes);
        } else {
            System.out.printf("%d:%d", hours, addedMinutes);
        }
    }
}
