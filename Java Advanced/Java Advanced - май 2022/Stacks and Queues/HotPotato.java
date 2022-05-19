import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Get kids
        String[] kids = scanner.nextLine().split("\\s+");

        //On which toos a child is gonna be removed
        int childTossRemoveNum = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String kid : kids) {
            //add every kid in the queue
            queue.offer(kid);
        }

        while (queue.size() > 1) {
            //Goes through every kid n times + on the last loop removes it from the playing circle
            for (int i = 1; i < childTossRemoveNum; i++) queue.offer(queue.poll());
            //Output: for removed
            System.out.println("Removed " + queue.poll());
        }
        //Output: for last kid left
        System.out.println("Last is " + queue.poll());
    }
}
