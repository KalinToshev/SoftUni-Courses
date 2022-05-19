import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Read the input
        String[] numbers = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (String number : numbers) {
            //Add every number to the stack from numbers[]
            stack.push(Integer.parseInt(number));
        }
        
        //Output numbers
        for (Integer integer : stack) {
            System.out.print(integer + " ");
        }
    }
}
