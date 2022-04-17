import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double squareMetersThatWillBeLandscaped = Double.parseDouble(scanner.nextLine());
        double finalPrice = squareMetersThatWillBeLandscaped * 7.61;
        double discount = finalPrice * 0.18;
        double finalDiscount = finalPrice - discount;
        System.out.printf("The final price is: %.2f lv.%n", finalDiscount);
        System.out.printf("The discount is: %.2f lv.", discount);
    }
}