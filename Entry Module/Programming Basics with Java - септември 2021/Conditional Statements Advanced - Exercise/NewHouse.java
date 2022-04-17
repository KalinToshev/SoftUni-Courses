import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String flowers = scanner.nextLine();
        int flowersCount = Integer.parseInt(scanner.nextLine());
        double budget = Double.parseDouble(scanner.nextLine());
        double totalSum = 0.0;
        switch (flowers) {
            case "Roses":
                totalSum = flowersCount * 5;
                if (flowersCount > 80) {
                    totalSum = totalSum - (totalSum * 0.1);
                }
                break;
            case "Dahlias":
                totalSum = flowersCount * 3.80;
                if (flowersCount > 90) {
                    totalSum = totalSum - (totalSum * 0.15);
                }
                break;
            case "Tulips":
                totalSum = flowersCount * 2.80;
                if (flowersCount > 80) {
                    totalSum = totalSum - (totalSum * 0.15);
                }
                break;
            case "Narcissus":
                totalSum = flowersCount * 3;
                if (flowersCount < 120) {
                    totalSum = totalSum + (totalSum * 0.15);
                }
                break;
            case "Gladiolus":
                totalSum = flowersCount * 2.50;
                if (flowersCount < 80) {
                    totalSum = totalSum + (totalSum * 0.2);
                }
                break;
        }
        if (budget >= totalSum) {
            double moneyLeft = budget - totalSum;
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.", flowersCount, flowers, moneyLeft);
        } else {
            double moneyNeeded = totalSum - budget;
            System.out.printf("Not enough money, you need %.2f leva more.", moneyNeeded);
        }
    }
}
