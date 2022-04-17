import java.util.Scanner;

public class MaxNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "SomeText";
        int max = Integer.MIN_VALUE;
        while (!text.equals("Stop")) {
            text = scanner.nextLine();
            if (text.equals("Stop")) {
                break;
            }
            int transform = Integer.parseInt(text);
            if (transform > max) {
                max = transform;
            }
        }
        System.out.println(max);
    }
}
