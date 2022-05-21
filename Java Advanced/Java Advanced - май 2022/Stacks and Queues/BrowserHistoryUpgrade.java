import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //stack
        ArrayDeque<String> back = new ArrayDeque<>();
        ArrayDeque<String> forward = new ArrayDeque<>();

        //Get input from the console
        String input;
        String currentUrl = null;
        while (!"Home".equals(input = scanner.nextLine())) {
            //Back command
            if ("back".equals(input)) {
                if (back.isEmpty()) {
                    System.out.println("no previous URLs");
                    continue;
                } else {
                    forward.push(currentUrl);
                    currentUrl = back.pop();
                }
            }
            //Forward command
            else if ("forward".equals(input)) {
                if (forward.isEmpty()) {
                    System.out.println("no next URLs");
                    continue;
                } else {
                    back.push(currentUrl);
                    currentUrl = forward.pop();
                }
            }
            //URL given
            else {
                if (currentUrl != null) {
                    back.push(currentUrl);
                }
                forward.clear();
                currentUrl = input;
            }
            //Output result based on command
            System.out.println(currentUrl);
        }
    }
}
