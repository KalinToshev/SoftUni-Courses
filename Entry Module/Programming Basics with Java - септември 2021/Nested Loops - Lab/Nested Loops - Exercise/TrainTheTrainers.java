import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int jury = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        double grade = 0;
        double sum = 0;
        double average = 0;
        int counter = 0;
        double totalAverage = 0;
        double totalSum = 0;
        int totalCounter = 0;

        while(!input.equals("Finish")) {
            for (int i = jury; i > 0; i--) {
                grade = Double.parseDouble(scanner.nextLine());
                counter++;
                totalCounter++;
                sum += grade;
                totalSum += grade;
                average = sum / counter;
                totalAverage = totalSum / totalCounter;
            }
            System.out.printf("%s - %.2f.%n", input, average);
            sum = 0;
            average = 0;
            counter = 0;
            input = scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.", totalAverage);
    }
}
