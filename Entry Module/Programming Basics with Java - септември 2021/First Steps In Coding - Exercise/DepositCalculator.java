import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double depositAmount = Double.parseDouble(scanner.nextLine());
        int termOfTheDeposit = Integer.parseInt(scanner.nextLine());
        double annualInterestRate = Double.parseDouble(scanner.nextLine());
        //1. Изчисляваме натрупаната лихва
        double accruedInterest = depositAmount * (annualInterestRate / 100);
        //2. Изчисляваме лихвата за 1 месец
        double interestFor1Month = accruedInterest / 12;
        //3. Общата сума е
        double totalSum = depositAmount + (termOfTheDeposit * interestFor1Month);
        System.out.println(totalSum);
    }
}
