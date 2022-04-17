import java.util.Scanner;

public class EvenPowersOf2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; n >= i; i+=2) {
            System.out.printf("%.0f%n", Math.pow(2,i));
        }
    }
}
