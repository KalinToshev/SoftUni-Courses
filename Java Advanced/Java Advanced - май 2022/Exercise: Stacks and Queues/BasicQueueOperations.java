import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nums = scanner.nextLine().split("\\s+");

        int numbersToPush = Integer.parseInt(nums[0]);
        int numbersToPop = Integer.parseInt(nums[1]);
        int elementToSearch = Integer.parseInt(nums[2]);

        //Read elements from the console
        String[] elements = scanner.nextLine().split("\\s+");

        //Create a queue to hold the elements
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        //Put elements in the queue based on numbersToPush
        for (int i = 0; i < numbersToPush; i++) {
            queue.offer(Integer.parseInt(elements[i]));
        }

        //Pop elements of the queue based on NumbersToPop
        for (int i = 0; i < numbersToPop; i++) {
            queue.poll();
        }

        //If elementToSearch is in the queue -> true, else min element in queue
        if (queue.contains(elementToSearch)) {
            System.out.println("true");
        } else {
            if (queue.isEmpty()) {
                System.out.println(0);
            } else {
                Integer min = Collections.min(queue);
                System.out.println(min);
            }
        }
    }
}
