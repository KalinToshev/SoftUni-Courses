import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       double budget = Double.parseDouble(scanner.nextLine());
       int videocards = Integer.parseInt(scanner.nextLine());
       int processors = Integer.parseInt(scanner.nextLine());
       int ramMemory = Integer.parseInt(scanner.nextLine());
       double moneyForVideocards = videocards * 250;
       double moneyForOneProcessor = moneyForVideocards * 0.35;
       double moneyForProcessors = moneyForOneProcessor * processors;
       double moneyForOneRamMemory = moneyForVideocards * 0.1;
       double moneyForRamMemories =  moneyForOneRamMemory * ramMemory;
       double totalSum = moneyForVideocards + moneyForProcessors + moneyForRamMemories;
       if (videocards > processors) {
           totalSum = totalSum - (totalSum * 0.15);
       }
       if (budget >= totalSum) {
           double moneyLeft = budget - totalSum;
           System.out.printf("You have %.2f leva left!", moneyLeft);
       } else {
           double moneyNeeded  = totalSum - budget;
           System.out.printf("Not enough money! You need %.2f leva more!", moneyNeeded);
       }
    }
}
