import java.util.Scanner;

public class ReadText {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String someText = scanner.nextLine();
        while(!(someText.equals("Stop"))) {
            System.out.println(someText);
            someText = scanner.nextLine();
        }
    }
}
