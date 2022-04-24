package bg.softuni.Basic_Syntax_Conditional_Statements_and_Loops;

import java.util.Scanner;

public class Foreign_Languages_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Input
        String country = scanner.nextLine();
        String language;

        switch (country) {
            case "England":
            case "USA":
                language = "English";
                break;
            case "Spain":
            case "Argentina":
            case "Mexico":
                language = "Spanish";
                break;
            default:
                language = "unknown";
                break;
        }
        //Output
        System.out.println(language);
    }
}
