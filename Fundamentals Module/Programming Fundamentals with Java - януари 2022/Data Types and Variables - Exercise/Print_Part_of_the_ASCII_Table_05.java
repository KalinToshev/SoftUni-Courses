package bg.softuni.Exercise_Data__Types_and__Variables;

import java.util.Scanner;

public class Print_Part_of_the_ASCII_Table_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        int start = Integer.parseInt(scanner.nextLine());
        int stop = Integer.parseInt(scanner.nextLine());
        //Compute
        for (int i = start; i <= stop; i++) {
            char symbol = (char)i;
            System.out.print(symbol + " ");
        }
    }
}
