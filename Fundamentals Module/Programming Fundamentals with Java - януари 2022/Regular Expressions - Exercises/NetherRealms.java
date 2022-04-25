package bg.softuni.ExerciseRegularExpressions;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NetherRealms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] demons = scanner.nextLine().split(",\\s+");

        //Create regex
        String lettersRegex = "[A-Za-z]";
        String negativeNumbersRegex = "-\\d+.\\d+";
        String positiveNumbersRegex1 = "\\d+";
        String positiveNumbersRegex2 = "\\d+.\\d+";
        String negativeNumbersRegex2 = "-\\d+";
        String operatorsRegex = "[*/]";

        Pattern letterPattern = Pattern.compile(lettersRegex);
        Pattern numbersPattern1 = Pattern.compile(negativeNumbersRegex);
        Pattern numbersPattern2 = Pattern.compile(positiveNumbersRegex1);
        Pattern numbersPattern3 = Pattern.compile(positiveNumbersRegex2);
        Pattern numbersPattern4 = Pattern.compile(negativeNumbersRegex2);
        Pattern operatorsPattern = Pattern.compile(operatorsRegex);

        double health = 0.0;
        double damage = 0.0;

        for (int i = 0; i < demons.length; i++) {
            String currentDemonName = demons[i];

            //Calculate health
            Matcher healthMatcher = letterPattern.matcher(currentDemonName);
            while (healthMatcher.find()) {
                char hp = healthMatcher.group().charAt(0);
                health += hp;
            }
            //Calculate base damage
            String demonNameCopy1 = currentDemonName;
            Matcher baseDamageMatcher1 = numbersPattern1.matcher(demonNameCopy1);
            boolean valid1 = baseDamageMatcher1.find();
            //-n.n
            if (valid1) {
                while (baseDamageMatcher1.find()) {
                    damage += Double.parseDouble(baseDamageMatcher1.group());
                }
            }

            String demonNameCopy2 = demonNameCopy1.replaceAll(negativeNumbersRegex, "");
            Matcher baseDamageMatcher2 = numbersPattern2.matcher(demonNameCopy2);
            boolean valid2 = baseDamageMatcher2.find();
            //+n
            if (valid2) {
                while (baseDamageMatcher2.find()) {
                    damage += Double.parseDouble(baseDamageMatcher2.group());
                }
            }

            String demonNameCopy3 = demonNameCopy2.replaceAll(positiveNumbersRegex1, "");
            Matcher baseDamageMatcher3 = numbersPattern3.matcher(demonNameCopy3);
            boolean valid3 = baseDamageMatcher3.find();
            //+n.n
            if (valid3) {
                while (baseDamageMatcher3.find()) {
                    damage += Double.parseDouble(baseDamageMatcher3.group());
                }
            }

            String demonNameCopy4 = demonNameCopy3.replaceAll(negativeNumbersRegex2, "");
            Matcher baseDamageMatcher4 = numbersPattern4.matcher(demonNameCopy4);
            boolean valid4 = baseDamageMatcher4.find();
            //-n
            if (valid4) {
                while (baseDamageMatcher4.find()) {
                    damage += Double.parseDouble(baseDamageMatcher4.group());
                }
            }

            //Calculate total damage
            Matcher totalDamageMatcher = operatorsPattern.matcher(currentDemonName);
            while (totalDamageMatcher.find()) {
                String operator = totalDamageMatcher.group();
                switch (operator) {
                    case "/":
                        damage /= 2;
                        break;
                    case "*":
                        damage *= 2;
                        break;
                }
            }

            //Output
            System.out.printf("%s - %.0f health, %.2f damage%n", currentDemonName, health, damage);

            //Reset damage and health for the new hero
            health = 0;
            damage = 0;
        }
    }
}
