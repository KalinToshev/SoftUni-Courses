import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //instruction
        String command = scanner.nextLine();

        //save instructions (stack)
        ArrayDeque<String> URLs = new ArrayDeque<>();

        while (!command.equals("Home")) {

            if (!command.equals("back")) {
                URLs.push(command);
                System.out.println(command);
            } else {
                if (URLs.size() > 1) {
                    //sets the current URL to the last set URL
                    URLs.pop();
                    System.out.println(URLs.peek());
                } else {
                    System.out.println("no previous URLs");
                }
            }

            //update command
            command = scanner.nextLine();
        }
    }
}
