package ConditionalStatements.Exercises;
 
import java.util.Scanner;
 
public class LunchTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
 
        String serialName = scanner.nextLine();
        int episodeDuration = Integer.parseInt(scanner.nextLine());
        int totalTime = Integer.parseInt(scanner.nextLine());
 
        // Времето за обяд ще бъде 1/8 от времето за почивка,
        double lunchTime = totalTime / 8.0;
        // а времето за отдих ще бъде 1/4 от времето за почивка.
        double restTime = totalTime / 4.0;
 
        double neededTime = episodeDuration + lunchTime + restTime;
 
        if (neededTime <= totalTime) {
            System.out.printf("You have enough time to watch %s " +
                            "and left with %.0f minutes free time."
                    , serialName, Math.ceil(totalTime - neededTime));
        } else {
            System.out.printf("You don't have enough time to watch %s," +
                            " you need %.0f more minutes."
                    , serialName, Math.ceil(neededTime - totalTime));
        }
 
 
    }
}
 