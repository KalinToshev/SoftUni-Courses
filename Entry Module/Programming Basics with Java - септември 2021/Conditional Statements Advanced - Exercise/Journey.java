import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String destination = "";
        String sleep = "";
        double cost = 0.0;

        switch (season) {
            case "summer":
                sleep = "Camp";
                if (budget <= 100) {
                    destination = "Bulgaria";
                    cost = budget * 0.3;
                } else if (budget <= 1000) {
                    destination = "Balkans";
                    cost = budget * 0.4;
                } else {
                    destination = "Europe";
                    sleep = "Hotel";
                    cost = budget * 0.9;
                }
                break;
            case "winter":
                sleep = "Hotel";
                if (budget <= 100) {
                    destination = "Bulgaria";
                    cost = budget * 0.7;
                } else if (budget <= 1000) {
                    destination = "Balkans";
                    cost = budget * 0.8;
                } else {
                    destination = "Europe";
                    sleep = "Hotel";
                    cost = budget * 0.9;
                }
                break;
        }
        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f", sleep, cost);
    }
}
