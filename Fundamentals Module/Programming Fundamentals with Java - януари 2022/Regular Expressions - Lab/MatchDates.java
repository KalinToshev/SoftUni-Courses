package bg.softuni.LabRegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Pattern pattern = Pattern.compile("\\b(?<day>\\d{2})([\\.\\-/])(?<month>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b");

        String input = scanner.nextLine();

        Matcher matcher = pattern.matcher(input);

        boolean validDate = matcher.find();
        while (validDate) {
            System.out.println("Day: " + matcher.group("day") + ", Month: " + matcher.group("month") + ", Year: " + matcher.group("year"));

            validDate = matcher.find();
        }
    }
}
