import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> names = new LinkedHashSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        fillSet(scanner, names, n);

        output(names);
    }

    private static void fillSet(Scanner scanner, Set<String> names, int n) {
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();

            names.add(name);
        }
    }

    private static void output(Set<String> names) {
        for (String name : names) {
            System.out.println(name);
        }
    }
}
