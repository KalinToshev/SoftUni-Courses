package bg.softuni.MethodsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class _08_MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        double power = Double.parseDouble(scanner.nextLine());

        System.out.println(new DecimalFormat("0.####").format(returnResultOfNumberOnPower(number, power)));
    }

    private static double returnResultOfNumberOnPower(double number, double power) {
        double result = Math.pow(number, power);
        return result;
    }
}
