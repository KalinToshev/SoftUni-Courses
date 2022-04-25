package bg.softuni.MethodsLab;

import java.util.Scanner;

public class _07_RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(printTheInputNTimes(input, n));
    }
    static String printTheInputNTimes(String input, int n) {
        String rst = "";

        for (int i = 1; i <= n; i++) {
            System.out.print(input);
        }

        return rst;
    }
}
