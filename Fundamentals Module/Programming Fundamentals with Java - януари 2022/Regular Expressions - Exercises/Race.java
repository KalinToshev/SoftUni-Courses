package bg.softuni.ExerciseRegularExpressions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    //G!32e%o7r#32g$235@!2e
    //The letters are the name of the person and the sum of the digits is the distance he ran
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Create regex
        String nameRegex = "[A-Za-z]+";
        String digitsRegex = "[\\d]{1}";

        //Get the data and split from the console input (names of participants)
        List<String> participants = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .collect(Collectors.toList());

        //Add the participants to the Map and their distances (currently 0)
        Map<String, Integer> participantsAndDistance = new LinkedHashMap<>();
        for (String participant : participants) {
            participantsAndDistance.putIfAbsent(participant, 0);
        }

        //Add and set patterns
        Pattern namePattern = Pattern.compile(nameRegex);
        Pattern distancePattern = Pattern.compile(digitsRegex);

        String line = scanner.nextLine();
        while (!line.equals("end of race")) {

            //Find letters only and append them to the String Builder
            Matcher nameMatcher = namePattern.matcher(line);
            StringBuilder sb = new StringBuilder();
            while (nameMatcher.find()) {
                sb.append(nameMatcher.group());
            }

            //Check if the given participant is valid
            if (participantsAndDistance.containsKey(sb.toString())) {
                //Sum digits from the given console line and add them to the participant distance
                Matcher distanceMatcher = distancePattern.matcher(line);
                while (distanceMatcher.find()) {
                    int digit = Integer.parseInt(distanceMatcher.group());
                    participantsAndDistance.put(sb.toString(), participantsAndDistance.get(sb.toString()) + digit);
                }
            }

            line = scanner.nextLine();
        }

        //Sort top 3 participants
        List<String> sorted = participantsAndDistance.entrySet().stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .map(Map.Entry::getKey).collect(Collectors.toList());
        String text = "";

        //Output the result
        for (int i = 0; i < sorted.size(); i++) {
            if (i == 3) {
                break;
            }
            text = i == 0 ? "st" : i == 1 ? "nd" : i == 2 ? "rd" : "";
            System.out.printf("%d%s place: %s%n", i + 1, text, sorted.get(i));
        }
    }
}
