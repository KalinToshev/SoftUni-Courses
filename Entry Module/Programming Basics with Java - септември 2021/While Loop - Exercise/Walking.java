import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int minSteps = 10000;
        int makedSteps = 0;
        while (minSteps > makedSteps) {
            String input = scanner.nextLine();
            if (input.equals("Going home")) {
                makedSteps += Integer.parseInt(scanner.nextLine());
                break;
            }
            makedSteps += Integer.parseInt(input);
        }
        if (makedSteps >= minSteps) {
            System.out.println("Goal reached! Good job!");
            System.out.printf("%d steps over the goal!%n", makedSteps - minSteps);
        } else {
            System.out.printf("%d more steps to reach goal.", minSteps - makedSteps);
        }
    }
}
