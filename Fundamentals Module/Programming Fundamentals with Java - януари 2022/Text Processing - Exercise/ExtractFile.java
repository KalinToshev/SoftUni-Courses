package bg.softuni.ExerciseTextProcessing;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        line = line.substring(line.lastIndexOf("\\") + 1);

        String[] info = line.split("\\.");

        output(info);

    }

    private static void output(String[] info) {
        System.out.println("File name: " + info[0]);
        System.out.println("File extension: " + info[1]);
    }
}
