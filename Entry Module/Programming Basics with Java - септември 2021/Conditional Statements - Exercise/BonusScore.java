import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialNumberOfPoints = Integer.parseInt(scanner.nextLine());
        double bonus = 0;
        if (initialNumberOfPoints <= 100) {
            bonus = 5;
        } else if (initialNumberOfPoints > 1000) {
            bonus = initialNumberOfPoints * 0.1;
        } else  {
            bonus = initialNumberOfPoints * 0.2;
        }
        //additionalBonus
        if (initialNumberOfPoints % 2 == 0) {
            bonus = bonus + 1;
        } else if (initialNumberOfPoints % 10 == 5) {
            bonus = bonus + 2;
        }
        //results
        System.out.println(bonus);
        System.out.println(initialNumberOfPoints + bonus);
    }
}
