package JavaAdvancedExam20February2021.MagicBox01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> firstBox = new ArrayDeque<>(); //queue
        Deque<Integer> secondBox = new ArrayDeque<>(); //stack

        //fill
        String[] firstInput = scanner.nextLine().split("\\s+");
        String[] secondInput = scanner.nextLine().split("\\s+");
        Arrays.stream(firstInput).mapToInt(Integer::parseInt).forEach(firstBox::offer);
        Arrays.stream(secondInput).mapToInt(Integer::parseInt).forEach(secondBox::push);

        int claimedItems = 0;
        while (!(firstBox.isEmpty() || secondBox.isEmpty())) {
            if ((firstBox.peek() + secondBox.peek()) % 2 == 0) {
                claimedItems += firstBox.peek() + secondBox.peek();
                firstBox.poll();
                secondBox.pop();
            } else {
                firstBox.addLast(secondBox.pop());
            }
        }

        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (secondBox.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }
        if (claimedItems >= 90) {
            System.out.println("Wow, your prey was epic! Value: " + claimedItems);
        } else {
            System.out.println("Poor prey... Value: " + claimedItems);
        }
    }
}
