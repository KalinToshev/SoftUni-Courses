package WorkingWithAbstractionLab.HotelReservation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] infoInput = scanner.nextLine().split(" ");

        double pricePerDay = Double.parseDouble(infoInput[0]);
        int numberOfDays = Integer.parseInt(infoInput[1]);
        Season season = Season.valueOf(infoInput[2]);
        DiscountType discountType = DiscountType.valueOf(infoInput[3]);

        System.out.printf("%.2f%n", PriceCalculator.calculateFinalPrice(pricePerDay, numberOfDays, season, discountType));
    }
}
