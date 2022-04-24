package bg.softuni.Exercise_Data__Types_and__Variables;

import java.util.Scanner;

public class Triples_of_Latin_Letters_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        int n = Integer.parseInt(scanner.nextLine());
        //Compute
        for (int i = 97; i < 97 + n; i++) {
            for (int j = 97; j < 97 + n; j++) {
                for (int k = 97; k < 97 + n; k++) {
                    //output
                    System.out.printf("%c%c%c%n", i, j, k);
                }
            }
        }
    }
}
