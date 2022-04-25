package bg.softuni.MapsLambdaAndStreamAPIExercise;

import java.util.*;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> students = new LinkedHashMap<>();

        List<String> removeStudent = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());

            if (!students.containsKey(studentName)) {
                students.put(studentName, new ArrayList<>());
                students.get(studentName).add(grade);
            } else {
                students.get(studentName).add(grade);
            }
        }

        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            boolean notValidStudent = false;
            double sumGrades = 0.0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                sumGrades += entry.getValue().get(i);
            }
            if (sumGrades / entry.getValue().size() < 4.50) {
                notValidStudent = true;
            }
            if (notValidStudent) {
                removeStudent.add(entry.getKey());
            }
        }

        for (String student : removeStudent) {
            students.remove(student);
        }

        for (Map.Entry<String, List<Double>> entry : students.entrySet()) {
            double avg = 0;
            for (int i = 0; i < entry.getValue().size(); i++) {
                avg += entry.getValue().get(i);
            }
            avg /= entry.getValue().size();
            System.out.printf("%s -> %.2f%n", entry.getKey(), avg);
        }
    }
}
