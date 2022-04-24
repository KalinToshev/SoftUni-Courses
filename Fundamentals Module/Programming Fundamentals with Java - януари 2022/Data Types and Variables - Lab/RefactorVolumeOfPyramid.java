package bg.softuni.Data_Types_and_Variables_Lab;

import java.util.Scanner;

public class RefactorVolumeOfPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double length, width, height, V = 0;
        System.out.print("Length: ");
        length = Double.parseDouble(scanner.nextLine());
        System.out.print("Width: ");
        width = Double.parseDouble(scanner.nextLine());
        System.out.print("Height: ");
        height = Double.parseDouble(scanner.nextLine());
        V = (length * width * height) / 3;
        System.out.printf("Pyramid Volume: %.2f", V);
    }
}
