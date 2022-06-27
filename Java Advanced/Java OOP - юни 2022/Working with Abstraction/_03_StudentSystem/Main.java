package WorkingWithAbstractionLab.StudentSystem;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Creates a student system
        StudentSystem studentSystem = new StudentSystem();

        String[] input = scanner.nextLine().split(" ");
        while (!input[0].equals("Exit")) {
            //Accepts a valid command and executes it
            studentSystem.executeCommand(input);

            //Updates the command flow
            input = scanner.nextLine().split(" ");
        }
    }
}
