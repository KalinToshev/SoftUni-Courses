import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double priceOfTheTrip = Double.parseDouble(scanner.nextLine());
        int numberOfPuzzles = Integer.parseInt(scanner.nextLine());
        int numberOfTalkingDolls = Integer.parseInt(scanner.nextLine());
        int numberOfTeddyBears = Integer.parseInt(scanner.nextLine());
        int numberOfMinions = Integer.parseInt(scanner.nextLine());
        int numberOfTrucks = Integer.parseInt(scanner.nextLine());
        int totalToys = numberOfPuzzles + numberOfTalkingDolls + numberOfTeddyBears + numberOfMinions + numberOfTrucks;
        double totalPrice = (numberOfPuzzles * 2.60) + (numberOfTalkingDolls * 3.00) + (numberOfTeddyBears * 4.10) + (numberOfMinions * 8.20) + (numberOfTrucks * 2.00);
        if (totalToys >= 50) {
            totalPrice = totalPrice - (totalPrice * 0.25);
        }
        double moneyForMagazineRent = totalPrice * 0.1;
        double moneyLeft = totalPrice - moneyForMagazineRent;
        if (moneyLeft >= priceOfTheTrip) {
            double moneyLeftInPocket = moneyLeft - priceOfTheTrip;
            System.out.printf("Yes! %.2f lv left.", moneyLeftInPocket);
        } else {
            double moneyNeeded = priceOfTheTrip - moneyLeft;
            System.out.printf("Not enough money! %.2f lv needed.", moneyNeeded);
        }
    }
}
