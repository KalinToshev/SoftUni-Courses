package bg.softuni.LabRegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchFullName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("\\b[A-Z][a-z]+ [A-Z][a-z]+\\b");

        String input = scanner.nextLine();

        Matcher matcher = pattern.matcher(input);

        boolean validName = matcher.find();
        while (validName) {

            System.out.print(matcher.group() + " ");

            validName = matcher.find();
        }
    }
}
