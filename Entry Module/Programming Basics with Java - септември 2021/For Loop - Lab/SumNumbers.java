import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Програмата чете n на брой цели числа
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int otherNumber = 0;
        //Програмата ги сумира
        for (int i = 1; i <= n; i++) {
            otherNumber = Integer.parseInt(scanner.nextLine());
            sum += otherNumber;
        }
        System.out.println(sum);
    }
}
