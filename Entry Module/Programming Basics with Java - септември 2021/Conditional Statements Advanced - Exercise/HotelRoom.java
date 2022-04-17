import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int overnights = Integer.parseInt(scanner.nextLine());

        double priceStudio = 0;
        double priceApartment = 0;

        switch (month) {
            case "May":
            case "October":
                priceStudio = 50;
                priceApartment = 65;
                if (overnights > 7 && overnights <= 14) {
                    priceStudio = priceStudio * 0.95;
                } else if (overnights > 14) {
                    priceStudio = priceStudio * 0.70;
                }
                break;

            case "June":
            case "September":
                priceStudio = 75.2;
                priceApartment = 68.7;
                if (overnights > 14) {
                    priceStudio = priceStudio * 0.8;
                }
                break;

            case "July":
            case "August":
                priceStudio = 76;
                priceApartment = 77;
                break;
        }
        if (overnights > 14) {
            priceApartment *= 0.9;
        }

        double finalPriceApt = priceApartment * overnights;
        double finalPriceSTd = priceStudio * overnights;

        System.out.printf("Apartment: %.2f lv.%n", finalPriceApt);
        System.out.printf("Studio: %.2f lv.", finalPriceSTd);
    }
}
