import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //•	Баскетболни кецове – цената им е 40% по-малка от таксата за една година
        //•	Баскетболен екип – цената му е 20% по-евтина от тази на кецовете
        //•	Баскетболна топка – цената ѝ е 1 / 4 от цената на баскетболния екип
        //•	Баскетболни аксесоари – цената им е 1 / 5 от цената на баскетболната топка
        //===================================
        //ВХОД
        //•	Годишната такса за тренировки по баскетбол – цяло число в интервала [0… 9999]
        //===================================
        int theAnnualFeeForBasketballTraining = Integer.parseInt(scanner.nextLine());
        //===================================
        //ИЗЧИСЛЕНИЯ
        //===================================
        double basketballSneakers = theAnnualFeeForBasketballTraining - (theAnnualFeeForBasketballTraining * 0.4);
        double basketballClothing = basketballSneakers - (basketballSneakers * 0.2);
        double basketballBall = basketballClothing / 4;
        double basketballAccessories = basketballBall / 5;
        double totalSum = theAnnualFeeForBasketballTraining + basketballSneakers + basketballClothing + basketballBall + basketballAccessories;
        System.out.println(totalSum);
    }
}
