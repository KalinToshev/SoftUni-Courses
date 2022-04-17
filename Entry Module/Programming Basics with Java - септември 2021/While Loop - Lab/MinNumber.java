import java.util.Scanner;

public class MinNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = "SomeText";
        int min = Integer.MAX_VALUE;
        while (!text.equals("Stop")) {
            text = scanner.nextLine();
            if (text.equals("Stop")) {
                break;
            }
            int transform = Integer.parseInt(text);
            if (min > transform) {
                min = transform;
            }
        }
        System.out.println(min);
    }
}
