package bg.softuni.ExerciseRegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "[^@\\-!:>]*@(?<planetName>[A-Za-z]+)[^@\\-!:>]*:(?<population>[\\d]+)[^@\\-!:>]*!(?<attackType>[AD])![^@\\-!:>]*->(?<soldierCount>[\\d]+)[^@\\-!:>]*";
        Pattern pattern = Pattern.compile(regex);

        List<String> attackedPlanets = new ArrayList<>();
        List<String> destroyedPlanets = new ArrayList<>();

        int count = 0;
        String decryptedMessage;

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            //to find [s,t,a,r] counts
            char[] ch = line.toLowerCase().toCharArray();
            for (char c : ch) {
                if (c == 's'
                || c == 't'
                || c == 'a'
                || c == 'r') {
                    count++;
                }
            }
            //to decrypt message
            char[] decrypt = line.toCharArray();
            StringBuilder sb = new StringBuilder();
            for (char decr : decrypt) {
                decr -= count;
                sb.append(decr);
            }
            //set the decrypted message
            decryptedMessage = sb.toString();
            //reset counter
            count = 0;

            Matcher matcher = pattern.matcher(decryptedMessage);
            while (matcher.find()) {
                //Find valid planet name and attack type
                String planetName = matcher.group("planetName");
                String attackType = matcher.group("attackType");
                //Separate planets
                switch (attackType) {
                    case "A":
                        attackedPlanets.add(planetName);
                        break;
                    case "D":
                        destroyedPlanets.add(planetName);
                        break;
                }
            }
        }
        //Sort planets
        Collections.sort(attackedPlanets);
        Collections.sort(destroyedPlanets);
        //Output
        System.out.println("Attacked planets: " + attackedPlanets.size());
        if (attackedPlanets.size() > 0) {
            attackedPlanets.forEach(s -> System.out.println("-> " + s));
        }
        System.out.println("Destroyed planets: " + destroyedPlanets.size());
        if (destroyedPlanets.size() > 0) {
            destroyedPlanets.forEach(s -> System.out.println("-> " + s));
        }
    }
}
