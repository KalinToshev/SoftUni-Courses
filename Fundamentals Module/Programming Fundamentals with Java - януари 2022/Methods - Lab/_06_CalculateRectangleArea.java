package bg.softuni.MethodsLab;

import java.util.Scanner;

public class _06_CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        int result = resultReturn(a, b);

        System.out.println(result);
    }
    static int resultReturn(int a, int b) {
        return a * b;
    }
}
