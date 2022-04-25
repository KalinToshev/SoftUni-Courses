package bg.softuni.LabRegularExpressions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("\\+359([- ])2\\1[\\d]{3}\\1[\\d]{4}\\b");

        String input = scanner.nextLine();

        Matcher matcher = pattern.matcher(input);

        List<String> validNumber = new ArrayList<>();

        boolean validPhoneNumber = matcher.find();
        while (validPhoneNumber) {

            validNumber.add(matcher.group());

            validPhoneNumber = matcher.find();
        }

        System.out.println(String.join(", ", validNumber));
    }
}
