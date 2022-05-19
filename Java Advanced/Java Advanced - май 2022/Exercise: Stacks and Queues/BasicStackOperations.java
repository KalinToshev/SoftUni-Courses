import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] nums = scanner.nextLine().split("\\s+");

        int numbersToPush = Integer.parseInt(nums[0]);
        int numbersToPop = Integer.parseInt(nums[1]);
        int elementToSearch = Integer.parseInt(nums[2]);

        //Read elements from the console
        String[] elements = scanner.nextLine().split("\\s+");

        //Create a stack to hold the elements
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        //Put elements in the stack based on numbersToPush
        for (int i = 0; i < numbersToPush; i++) {
            stack.push(Integer.parseInt(elements[i]));
        }

        //Pop elements of the stack based on NumbersToPop
        for (int i = 0; i < numbersToPop; i++) {
            stack.pop();
        }

        //If elementToSearch is in the stack -> true, else min element in stack
        if (stack.contains(elementToSearch)) {
            System.out.println("true");
        } else {
            if (stack.isEmpty()) {
                System.out.println(0);
            } else {
                Integer min = Collections.min(stack);
                System.out.println(min);
            }
        }
    }
}
