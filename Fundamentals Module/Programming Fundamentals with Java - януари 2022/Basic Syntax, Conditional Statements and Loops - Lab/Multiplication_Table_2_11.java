package bg.softuni.Basic_Syntax_Conditional_Statements_and_Loops;

import java.util.Scanner;

public class Multiplication_Table_2_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        int theInteger = Integer.parseInt(scanner.nextLine());
        int times = Integer.parseInt(scanner.nextLine());

        //Output
        if (times > 10) {
            System.out.println(theInteger + " X " + times + " = " + theInteger * times);
        } else if (times <= 10) {
            do {
                System.out.println(theInteger + " X " + times + " = " + theInteger * times);
                times++;
            } while (times <= 10);
        }
    }
}
