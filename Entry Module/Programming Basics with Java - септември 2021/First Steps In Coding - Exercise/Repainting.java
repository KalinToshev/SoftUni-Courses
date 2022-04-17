import java.util.Scanner;

public class Repainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Предпазен найлон - 1.50 лв. за кв. метър
        //•	Боя - 14.50 лв. за литър
        //•	Разредител за боя - 5.00 лв. за литър
        //=======================================
        //1. Необходимо количество найлон (в кв.м.) - цяло число в интервала [1... 100]
        //2. Необходимо количество боя (в литри) - цяло число в интервала [1…100]
        //3. Количество разредител (в литри) - цяло число в интервала [1…30]
        //4. Часовете, за които майсторите ще свършат работата - цяло число в интервала [1…9]
        //=======================================
        int theRequiredAmountOfNylon = Integer.parseInt(scanner.nextLine());
        int theRequiredAmountOfCombat = Integer.parseInt(scanner.nextLine());
        int amountOfThinner = Integer.parseInt(scanner.nextLine());
        int theHoursForWhichTheMastersWillDoTheWork = Integer.parseInt(scanner.nextLine());
        //=======================================
        //1. Цена за найлон
        //2. Цена за боя
        //3. Цена за разредител
        //4. Обща цена на всички разходи за материали
        //5. Цена за майсторите
        //=======================================
        double priceForNylon = (theRequiredAmountOfNylon + 2) * 1.5;
        double priceForPaint = (theRequiredAmountOfCombat + (theRequiredAmountOfCombat*0.1)) * 14.50;
        double priceForThinner = amountOfThinner * 5.00;
        double totalSumOfMaterials = priceForNylon + priceForPaint + priceForThinner + 0.40;
        double priceForTheMastersFor1Hour = totalSumOfMaterials * 0.3;
        double totalPriceForTheMasters = priceForTheMastersFor1Hour * theHoursForWhichTheMastersWillDoTheWork;
        //=======================================
        //1. Общата сума от всички разходи
        //=======================================
        double totalSum = totalSumOfMaterials + totalPriceForTheMasters;
        //=======================================
        //1. Принтираме сумата на всички разходи
        //=======================================
        System.out.println(totalSum);
    }
}
