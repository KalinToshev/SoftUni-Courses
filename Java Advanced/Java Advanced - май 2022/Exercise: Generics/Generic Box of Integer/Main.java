package GenericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<Integer> box = new Box<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String line = scanner.nextLine();
            int number = Integer.parseInt(line);
            box.add(number);
        }

        System.out.println(box);
    }
}
