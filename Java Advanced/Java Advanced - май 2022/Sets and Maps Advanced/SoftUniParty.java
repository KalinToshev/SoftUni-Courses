import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> vip = new TreeSet<>();
        Set<String> regular = new TreeSet<>();

        String fInput;
        while (!"PARTY".equals(fInput = scanner.nextLine())) {
            if (Character.isDigit(fInput.charAt(0))) vip.add(fInput);
            else regular.add(fInput);
        }

        String sInput;
        while (!"END".equals(sInput = scanner.nextLine())) {
            vip.remove(sInput);
            regular.remove(sInput);
        }

        output(vip, regular);
    }

    private static void output(Set<String> vip, Set<String> regular) {
        System.out.println(vip.size() + regular.size());
        for (String s : vip) {
            System.out.println(s);
        }
        for (String s : regular) {
            System.out.println(s);
        }
    }
}
