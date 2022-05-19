import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberCommands = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numberCommands; i++) {
            //Read and save the command
            int[] command = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int commandType = command[0];
            switch (commandType) {
                case 1:
                    //Push element to the stack
                    stack.push(command[1]);
                    break;
                case 2:
                    //Delete last element
                    stack.pop();
                    break;
                case 3:
                    //Print max element from the stack
                    System.out.println(Collections.max(stack));
                    break;
            }
        }
    }
}
