package bg.softuni.Exercise_Basic_Syntax_Conditional_Statements_and_Loops;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        String username = scanner.nextLine();
        String password = "";
        String input = scanner.nextLine();
        int wrong_password_count = 0;
        //Compute
        for (int i = username.length() - 1; i >= 0; i--) {
            password += username.charAt(i);
        }
        while (true) {
            if (input.equals(password)) {
                System.out.printf("User %s logged in.", username);
                break;
            } else {
                wrong_password_count++;
                if (wrong_password_count == 4) {
                    System.out.printf("User %s blocked!", username);
                    break;
                }
                System.out.println("Incorrect password. Try again.");
            }
            input = scanner.nextLine();
        }
    }
}
