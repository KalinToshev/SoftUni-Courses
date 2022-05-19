import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String command = scanner.nextLine();
        while (!command.equals("print")) {

            if (!command.equals("cancel")) {
                queue.offer(command);
            } else {
                //If queue is empty
                if (queue.isEmpty()) {
                    System.out.println("Printer is on standby");
                } else {
                    //Remove first file in order
                    String canceled = queue.poll();
                    System.out.println("Canceled " + canceled);
                }
            }

            command = scanner.nextLine();
        }
        //Print the filenames
        for (String filename : queue) {
            System.out.println(filename);
        }
    }
}
