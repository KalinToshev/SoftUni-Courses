import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            double needBudget = Double.parseDouble(scanner.nextLine());
            double savedMoney = 0;
            while (savedMoney < needBudget) {
                double money = Double.parseDouble(scanner.nextLine());
                savedMoney += money;
            }
            System.out.println("Going to " + input + "!");
            input = scanner.nextLine();
        }
    }
}
