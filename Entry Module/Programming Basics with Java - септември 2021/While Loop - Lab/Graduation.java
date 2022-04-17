import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        int countGrade = 0;
        int countLowGrade = 0;
        double sumGrades = 0;

        while (countGrade != 12) {
            double currentGrade = Double.parseDouble(scanner.nextLine());
            sumGrades += currentGrade;
            if (currentGrade < 4.00) {
                countLowGrade++;
                if (countLowGrade > 1) {
                    System.out.printf("%s has been excluded at %d grade",
                            name, countGrade);
                    break;
                }
            }
            countGrade++;
        }

        if (countGrade == 12) {
            System.out.printf("%s graduated. Average grade: %.2f",
                    name, sumGrades / 12);
        }

    }
}