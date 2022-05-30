import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> emails = new LinkedHashMap<>();

        String line;
        while (!"stop".equals(line = scanner.nextLine())) {
            String mail = scanner.nextLine();
            if (isValid(mail)) {
                emails.put(line, mail);
            }
        }

        emails.forEach((k, v) -> System.out.printf("%s -> %s%n", k, v));
    }

    private static boolean isValid(String mail) {
        String endPart = mail.split("@")[1];
        String endPartSeparated = endPart.split("\\.")[1];
        return !mail.endsWith("us") && !mail.endsWith("com") && !mail.endsWith("uk");
    }
}

