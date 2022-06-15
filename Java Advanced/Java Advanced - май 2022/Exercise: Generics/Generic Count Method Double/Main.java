package GenericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<Double> box = new Box<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String line = scanner.nextLine();
            double element = Double.parseDouble(line);
            box.add(element);
        }
        double compareValue = Double.parseDouble(scanner.nextLine());;

        System.out.println(box.countGreaterItems(compareValue));
    }
}
