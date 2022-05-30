import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> personAndPhone = new LinkedHashMap<>();

        String info;
        fill(scanner, personAndPhone);

        String search;
        output(scanner, personAndPhone);
    }

    private static void fill(Scanner scanner, Map<String, String> personAndPhone) {
        String info;
        while (!"search".equals(info = scanner.nextLine())) {
            String[] data = info.split("-");
            if (!personAndPhone.containsKey(data[0])) {
                personAndPhone.put(data[0], data[1]);
            } else {
                personAndPhone.put(data[0], data[1]);
            }
        }
    }

    private static void output(Scanner scanner, Map<String, String> personAndPhone) {
        String search;
        while (!"stop".equals(search = scanner.nextLine())) {
            if (personAndPhone.containsKey(search)) {
                System.out.println(search + " -> " + personAndPhone.get(search));
            } else {
                System.out.println("Contact " + search + " does not exist.");
            }
        }
    }
}
