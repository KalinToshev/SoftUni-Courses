import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double movieBudget = Double.parseDouble(scanner.nextLine());
        int numberOfExtras = Integer.parseInt(scanner.nextLine());
        double priceForClothingOfOneExtra = Double.parseDouble(scanner.nextLine());
        double decor = movieBudget * 0.1;
        if (numberOfExtras > 150) {
            priceForClothingOfOneExtra = priceForClothingOfOneExtra - (priceForClothingOfOneExtra * 0.1);
        }
        double priceForClothingOfAllExtras = numberOfExtras * priceForClothingOfOneExtra;
        double decorPlusExtras = decor + priceForClothingOfAllExtras;
        if (decorPlusExtras > movieBudget) {
            double neededMoney = decorPlusExtras - movieBudget;
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", neededMoney);
        } else if (decorPlusExtras <= movieBudget){
            double moneyLeft = movieBudget - decorPlusExtras;
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", moneyLeft);
        }
    }
}
