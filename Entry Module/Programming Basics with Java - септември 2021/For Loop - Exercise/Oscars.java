import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameOfActor = scanner.nextLine();
        double pointsByTheAcademy = Double.parseDouble(scanner.nextLine());
        int numberOfGraders = Integer.parseInt(scanner.nextLine());
        String nameOfGrader = null;
        double pointsByGrader = 0.0;
        for (int i = 0; i < numberOfGraders; i++) {
            nameOfGrader = scanner.nextLine();
            pointsByGrader = Double.parseDouble(scanner.nextLine());
            pointsByTheAcademy = pointsByTheAcademy + ((nameOfGrader.length()*pointsByGrader) / 2);
            if (pointsByTheAcademy > 1250.5) {
                break;
            }
        }
        if (pointsByTheAcademy < 1250.5) {
            System.out.printf("Sorry, %s you need %.1f more!", nameOfActor, 1250.5 - pointsByTheAcademy);
        } else {
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", nameOfActor, pointsByTheAcademy);
        }
    }
}
