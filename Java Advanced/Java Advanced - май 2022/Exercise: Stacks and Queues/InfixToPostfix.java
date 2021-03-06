import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InfixToPostfix {
    static ArrayDeque<Operators> stack = new ArrayDeque<>();
    static ArrayDeque<String> outputQueue = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");


        for (String c : input) {
            Operators operator = Operators.getByName(c);

            if (operator == null) {
                outputQueue.offer(c);
            } else {
                handleOperator(operator);
            }
        }

        emptyStackInTheQueue();
        printQueue();
    }

    private static void printQueue() {
        for (String c : outputQueue) {
            System.out.print(c + " ");
        }
    }

    private static void handleOperator(Operators operator) {

        switch (operator) {
            case OPEN_BRACKET:
                stack.push(operator);
                break;
            case CLOSE_BRACKET:
                Operators last = stack.pop();
                while (!stack.isEmpty() && last != Operators.OPEN_BRACKET) {
                    outputQueue.offer(last.name);
                    last = stack.pop();
                }
                break;
            default:
                while (!stack.isEmpty() && operator.power <= stack.peek().power) {
                    outputQueue.offer(stack.pop().name);
                }
                stack.push(operator);
                break;
        }
    }

    private static void emptyStackInTheQueue() {
        while (!stack.isEmpty()) {
            outputQueue.offer(stack.pop().name);
        }
    }
    
    private enum Operators {

        OPEN_BRACKET("(", 1),
        CLOSE_BRACKET(")", 1),
        ADD("+", 2),
        SUBTRACT("-", 2),
        MULTIPLY("*", 3),
        DIVISION("/", 3),
        POWER("^", 4);

        public final String name;
        public final int power;
        private static final Map<String, Operators> BY_NAME = new HashMap<>();

        Operators(String name, int power) {
            this.name = name;
            this.power = power;
        }

        static {
            for (Operators value : values()) {
                BY_NAME.put(value.name, value);
            }
        }

        public static Operators getByName(String name) {
            return BY_NAME.get(name);
        }
    }
}
