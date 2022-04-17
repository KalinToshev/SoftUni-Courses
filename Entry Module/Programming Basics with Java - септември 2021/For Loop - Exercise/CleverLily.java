import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int yearsOld = Integer.parseInt(scanner.nextLine());
        double priceOfWasher = Double.parseDouble(scanner.nextLine());
        double priceOfGames = Double.parseDouble(scanner.nextLine());
        int toys = 0;
        double money = 0.00;
        int moneyCount = 0;
        double totalMoney = 0.0;
        for (int i = 1; i <= yearsOld; i++) {
            if (i % 2 == 1) {
                toys++;
            }
            if (i % 2 == 0) {
                money+=10.00;
                totalMoney+=money;
                moneyCount++;
            }
        }
        double selledToys = toys * priceOfGames;
        double totalMoneyMade = (totalMoney + selledToys) - (moneyCount * 1);
        if (totalMoneyMade >= priceOfWasher) {
            System.out.printf("Yes! %.2f", totalMoneyMade - priceOfWasher);
        } else {
            System.out.printf("No! %.2f", priceOfWasher - totalMoneyMade);
        }
    }
}
