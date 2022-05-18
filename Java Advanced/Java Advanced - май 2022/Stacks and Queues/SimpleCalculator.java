import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");

        ArrayDeque<String> stack = new ArrayDeque<>();
        //Add tokens to Stack
        Collections.addAll(stack, tokens);

        while (stack.size() > 1) {
            int result = 0;
            //Get the two numbers and operator
            int p1 = Integer.parseInt(stack.pop());
            String op = stack.pop();
            int p2 = Integer.parseInt(stack.pop());

            //Calculate the result
            getResult(stack, p1, op, p2);
        }

        //Print the result
        System.out.println(stack.pop());
    }
    private static void getResult(ArrayDeque<String> stack, int p1, String op, int p2) {
        int result;
        switch (op) {
            case "+":
                result = p1 + p2;
                stack.push(String.valueOf(result));
                break;
            case "-":
                result = p1 - p2;
                stack.push(String.valueOf(result));
                break;
        }
    }
}
