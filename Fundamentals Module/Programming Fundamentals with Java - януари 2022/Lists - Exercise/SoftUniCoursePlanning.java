package bg.softuni.ListExercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SoftUniCoursePlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> schedule = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String line = scanner.nextLine();
        while (!line.equals("course start")) {
            String[] tokens = line.split(":");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String lessonTitle = tokens[1];
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    lessonTitle = tokens[1];
                    int index = Integer.parseInt(tokens[2]);
                    if (!schedule.contains(lessonTitle)) {
                        schedule.add(index, lessonTitle);
                    }
                    break;
                case "Remove":
                    lessonTitle = tokens[1];
                    schedule.remove(lessonTitle);
                    schedule.remove(lessonTitle + "-Exercise");
                    break;
                case "Swap":
                    lessonTitle = tokens[1];
                    String swapWithLesson = tokens[2];
                    String firstLessonEx = lessonTitle + "-Exercise";
                    String secondLessonEx = swapWithLesson + "-Exercise";
                    if (schedule.contains(lessonTitle) && schedule.contains(swapWithLesson)) {
                        int lessonTitleIndex = schedule.indexOf(lessonTitle);
                        int swapWithIndex = schedule.indexOf(swapWithLesson);
                        Collections.swap(schedule,lessonTitleIndex,swapWithIndex);
                    }
                    if (schedule.contains(firstLessonEx)) {
                        Collections.swap(schedule,schedule.indexOf(firstLessonEx),schedule.indexOf(lessonTitle) + 1);
                    }
                    if (schedule.contains(secondLessonEx)) {
                        schedule.remove(secondLessonEx);
                        schedule.add(schedule.indexOf(swapWithLesson) + 1, secondLessonEx);
                    }
                    break;
                case "Exercise":
                    lessonTitle = tokens[1];
                    String exercise = lessonTitle + "-Exercise";
                    if (schedule.contains(lessonTitle) && !schedule.contains(exercise)) {
                        schedule.add(schedule.indexOf(lessonTitle) + 1, exercise);
                    } else if (!schedule.contains(lessonTitle)) {
                        schedule.add(lessonTitle);
                        schedule.add(exercise);
                    }
                    break;
            }

            line = scanner.nextLine();
        }
        for (int i = 1; i <= schedule.size(); i++) {
            System.out.println(i + "." + schedule.get(i - 1));
        }
    }
}
