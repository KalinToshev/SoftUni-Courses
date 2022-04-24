package bg.softuni.Basic_Syntax_Conditional_Statements_and_Loops;

import java.util.Scanner;

public class Passed_or_Failed_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        String passed_or_failed;
        double grade = Double.parseDouble(scanner.nextLine());

        //Cheking the assesment
        if (grade >= 3) {
            passed_or_failed = "Passed!";
        } else {
            passed_or_failed = "Failed!";
        }

        //Output
        System.out.println(passed_or_failed);
    }
}
