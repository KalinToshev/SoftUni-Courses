import java.util.Scanner;

public class PetShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int theNumberOfPackagesOfDogFood = Integer.parseInt(scanner.nextLine());
        int theNumberOfPackagesOfCatFood = Integer.parseInt(scanner.nextLine());
        double totalAmountForDogPacks = theNumberOfPackagesOfDogFood * 2.50;
        double totalAmountForCatPacks = theNumberOfPackagesOfCatFood * 4;
        double totalAmount = totalAmountForCatPacks + totalAmountForDogPacks;
        System.out.printf("%.1f lv.", totalAmount);
    }
}