import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sequenceOfParentheses = scanner.nextLine();

        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();

        boolean isBalanced = true;

        //Go through every bracket
        for (int i = 0; i < sequenceOfParentheses.length(); i++) {
            char currentBracket = sequenceOfParentheses.charAt(i);
            //Put every opening bracket to the stack
            if (currentBracket == '{'
                    || currentBracket == '('
                    || currentBracket == '[') {
                openingBrackets.push(currentBracket);
            } else {
                if (openingBrackets.isEmpty()) {
                    isBalanced = false;
                    break;
                }
                //Get closing bracket and add it to the char variable
                char lastOpeningBracket = openingBrackets.pop();
                //Check if there is not equal brackets (NOT BALANCED)
                if (currentBracket == '}'&& lastOpeningBracket != '{') {
                    isBalanced = false;
                    break;
                } else if (currentBracket == ')'&& lastOpeningBracket != '(') {
                    isBalanced = false;
                    break;
                } else if (currentBracket == ']'&& lastOpeningBracket != '[') {
                    isBalanced = false;
                    break;
                }
            }
        }

        //OUTPUT
        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
