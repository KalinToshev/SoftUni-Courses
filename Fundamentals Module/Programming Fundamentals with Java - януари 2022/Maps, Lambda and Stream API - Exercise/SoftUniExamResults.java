package bg.softuni.MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> userInfo = new LinkedHashMap<>();
        Map<String, Integer> submissionsCounter = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("exam finished")) {
            String[] data = line.split("-");
            if (data.length == 3) {
                if (!userInfo.containsKey(data[0])) {
                    userInfo.put(data[0], Integer.parseInt(data[2]));
                } else {
                    if (userInfo.get(data[0]) < Integer.parseInt(data[2])) {
                        userInfo.put(data[0], Integer.parseInt(data[2]));
                    }
                }

                if (!submissionsCounter.containsKey(data[1])) {
                    submissionsCounter.put(data[1], 1);
                } else {
                    submissionsCounter.put(data[1], submissionsCounter.get(data[1]) + 1);
                }
            }else {
                userInfo.remove(data[0]);
            }

            line = scanner.nextLine();
        }
        System.out.println("Results:");
        userInfo.forEach((k, v) -> System.out.printf("%s | %d%n", k, v));
        System.out.println("Submissions:");
        submissionsCounter.forEach((k, v) -> System.out.printf("%s - %d%n", k, v));
    }
}
