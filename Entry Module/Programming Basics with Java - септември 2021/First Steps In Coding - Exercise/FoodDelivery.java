import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //======================================
        // • Пилешко меню –  10.35 лв.
        // • Меню с риба – 12.40 лв.
        // • Вегетарианско меню  – 8.15 лв.
        // • Групата ще си поръча и десерт, чиято цена е равна на 20% от общата сметка
        // • Цената на доставка е 2.50 лв
        //======================================
        //ВХОД
        // • Брой пилешки менюта – цяло число в интервала [0 … 99]
        // • Брой менюта с риба – цяло число в интервала [0 … 99]
        // • Брой вегетариански менюта – цяло число в интервала [0 … 99]
        //======================================
        int numberOfChickenMenus = Integer.parseInt(scanner.nextLine());
        int numberOfFishMenus = Integer.parseInt(scanner.nextLine());
        int numberOfVegetarianMenus = Integer.parseInt(scanner.nextLine());
        //======================================
        //ИЗЧИСЛЕНИЯ
        // • Обща сума за пилешките менюта
        // • Обща сума за рибните менюта
        // • Обща сума за вегетарианските менюта
        // • Сума за десерт
        // • Цялата сума(с доставката)
        //======================================
        double totalAmountForChickenMenus = numberOfChickenMenus * 10.35;
        double totalAmountForFishMenus = numberOfFishMenus * 12.40;
        double totalForVegetarianMenus = numberOfVegetarianMenus * 8.15;
        double amountForDessert = (totalAmountForChickenMenus + totalAmountForFishMenus + totalForVegetarianMenus) * 0.2;
        double totalSum = (totalAmountForChickenMenus + totalAmountForFishMenus + totalForVegetarianMenus) + amountForDessert + 2.50;
        System.out.println(totalSum);
    }
}
