import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Пакет химикали - 5.80 лв.
        //Пакет маркери - 7.20 лв.
        //Препарат - 1.20 лв (за литър)
        /*
          От конзолата се четат 4 числа:
          Брой пакети химикали - цяло число в интервала [0...100]
          Брой пакети маркери - цяло число в интервала [0...100]
          Литри препарат за почистване на дъска - цяло число в интервала [0…50]
          Процент намаление - цяло число в интервала [0...100]
         */
        int numberOfPackagesOfChemicals = Integer.parseInt(scanner.nextLine());
        int numberOfPacketMarkers = Integer.parseInt(scanner.nextLine());
        int litersOfBoardCleaner = Integer.parseInt(scanner.nextLine());
        double discount = Integer.parseInt(scanner.nextLine());
        double totalSum = (numberOfPackagesOfChemicals * 5.80) + (numberOfPacketMarkers * 7.20) + (litersOfBoardCleaner * 1.20);
        double transformedDiscount = discount / 100;
        double totalSumWithDiscount = totalSum - (totalSum * transformedDiscount);
        System.out.println(totalSumWithDiscount);
    }
}
