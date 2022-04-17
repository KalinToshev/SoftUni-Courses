import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = Double.parseDouble(scanner.nextLine()) * 100;
        int coinsCount = 0;
        while (money >= 1) {
            if (money >= 200) {
                coinsCount += Math.floor(money / 200);
                money %= 200;
            } else if (money >= 100) {
                coinsCount += Math.floor(money / 100);
                money %= 100;
            } else if (money >= 50) {
                coinsCount += Math.floor(money / 50);
                money %= 50;
            } else if (money >= 20) {
                coinsCount += Math.floor(money / 20);
                money %= 20;
            } else if (money >= 10) {
                coinsCount += Math.floor(money / 10);
                money %= 10;
            } else if (money >= 5) {
                coinsCount += Math.floor(money / 5);
                money %= 5;
            } else if (money >= 2) {
                coinsCount += Math.floor(money / 2);
                money %= 2;
            } else {
                coinsCount += Math.floor(money);
                money %= 1;
            }
        }

        System.out.println(coinsCount);
    }
}