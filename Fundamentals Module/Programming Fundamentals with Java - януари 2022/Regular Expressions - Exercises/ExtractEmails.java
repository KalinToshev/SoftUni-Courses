package bg.softuni.ExerciseRegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        Pattern pattern = Pattern.compile("(?<=\\s)[a-zA-Z0-9]+([-.]\\w+)*@[a-zA-Z]+?([.-][a-zA-Z]*)*(\\.[a-z]{2,})");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
