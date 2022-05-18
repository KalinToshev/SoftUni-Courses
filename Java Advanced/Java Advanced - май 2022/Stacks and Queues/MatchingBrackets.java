import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        //Get the expression
        String expression = scanner.nextLine();

        //Get every char from the expression
        char[] ch = expression.toCharArray();

        //Loop through the ch[]
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '(') {
                stack.push(i);
            } else if (ch[i] == ')') {
                //get start index of a substring
                int startIndex = stack.pop();
                //Get the subStr
                String subStr = expression.substring(startIndex, i + 1);
                //Print the subStr
                System.out.println(subStr);
            }
        }
    }
}
