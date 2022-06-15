package GenericSwapMethodStrings;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<String> box = new Box<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String line = scanner.nextLine();
            box.add(line);
        }
        String indexes = scanner.nextLine();

        box.swap(Integer.parseInt(indexes.split(" ")[0]),Integer.parseInt(indexes.split(" ")[1]));

        System.out.println(box);
    }
}
