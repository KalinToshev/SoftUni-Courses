package bg.softuni.MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> courseAndStudents = new LinkedHashMap<>();

        String command = scanner.nextLine();
        while (!command.equals("end")) {

            String[] tokens = command.split(" : ");
            String courseName = tokens[0];
            String name = tokens[1];

            if (!courseAndStudents.containsKey(courseName)) {
                courseAndStudents.put(courseName, new ArrayList<>());
                courseAndStudents.get(courseName).add(name);
            } else {
                if (!courseAndStudents.get(courseName).contains(name)) {
                    courseAndStudents.get(courseName).add(name);
                }
            }

            command = scanner.nextLine();
        }
        for (Map.Entry<String, List<String>> entry : courseAndStudents.entrySet()) {
            System.out.print(entry.getKey() + ": " + courseAndStudents.get(entry.getKey()).size());
            System.out.println();
            for (int i = 0; i < courseAndStudents.get(entry.getKey()).size(); i++) {
                System.out.println("-- " + courseAndStudents.get(entry.getKey()).get(i));
            }
        }

    }
}
