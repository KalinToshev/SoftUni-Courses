import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        int fishers = Integer.parseInt(scanner.nextLine());

        double rent = 0.0;

        switch (season) {
            case "Spring":
                rent = 3000;
                if (fishers <= 6) {
                    rent = rent - (rent * 0.1);
                } else if (fishers >= 7 && fishers <= 11) {
                    rent = rent - (rent * 0.15);
                } else {
                    rent = rent - (rent * 0.25);
                }
                if (fishers % 2 == 0 && !season.equals("Autumn")) {
                    rent = rent - (rent * 0.05);
                }
                break;
            case "Summer":
            case "Autumn":
                rent = 4200;
                if (fishers <= 6) {
                    rent = rent - (rent * 0.1);
                } else if (fishers >= 7 && fishers <= 11) {
                    rent = rent - (rent * 0.15);
                } else {
                    rent = rent - (rent * 0.25);
                }
                if (fishers % 2 == 0 && !season.equals("Autumn")) {
                    rent = rent - (rent * 0.05);
                }
                break;
            case "Winter":
                rent = 2600;
                if (fishers <= 6) {
                    rent = rent - (rent * 0.1);
                } else if (fishers >= 7 && fishers <= 11) {
                    rent = rent - (rent * 0.15);
                } else {
                    rent = rent - (rent * 0.25);
                }
                if (fishers % 2 == 0 && !season.equals("Autumn")) {
                    rent = rent - (rent * 0.05);
                }
                break;
        }
        if (budget >= rent) {
            double moneyLeft = budget - rent;
            System.out.printf("Yes! You have %.2f leva left.", moneyLeft);
        } else {
            double moneyNeeded = rent - budget;
            System.out.printf("Not enough money! You need %.2f leva.", moneyNeeded);
        }
    }
}
