package bg.softuni.Exercise_Data__Types_and__Variables;

import java.util.Scanner;

public class Sum_of_Chars_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        //Compute
        for (int i = 1; i <= n; i++) {
            char symbol = scanner.nextLine().charAt(0);
            sum += symbol;
        }
        //Output
        System.out.println("The sum equals: " + sum);
    }
}
