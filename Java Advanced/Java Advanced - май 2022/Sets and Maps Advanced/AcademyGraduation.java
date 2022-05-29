import java.text.DecimalFormat;
import java.util.*;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());

        Map<String, double[]> studentAndScores = new TreeMap<>();

        fillMap(scanner, numberOfStudents, studentAndScores);

        output(studentAndScores);
    }

    private static void fillMap(Scanner scanner, int numberOfStudents, Map<String, double[]> studentAndScores) {
        for (int i = 0; i < numberOfStudents; i++) {
            String nameOfTheStudent = scanner.nextLine();

            double[] score = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

            studentAndScores.putIfAbsent(nameOfTheStudent, score);
        }
    }

    private static void output(Map<String, double[]> studentAndScores) {
        String pattern ="#.###################################";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        for (Map.Entry<String, double[]> student : studentAndScores.entrySet()) {
            double average = 0;
            for (double v : student.getValue()) {
                average += v;
            }
            average /= student.getValue().length;

            System.out.printf("%s is graduated with %s%n", student.getKey(), decimalFormat.format(average));
        }
    }
}
