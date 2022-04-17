import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfGropus = Integer.parseInt(scanner.nextLine());
        double numberOfPeopleInGroup = 0;
        double totalCountOfPeople = 0;
        double musala = 0.0;
        double montBlanc = 0.0;
        double kilimanjaro = 0.0;
        double kTwo = 0.0;
        double everest = 0.0;
        for (int i = 1; i <= numberOfGropus; i++) {
            numberOfPeopleInGroup = Double.parseDouble(scanner.nextLine());
            totalCountOfPeople+=numberOfPeopleInGroup;
            if (numberOfPeopleInGroup <= 5) {
                musala+=numberOfPeopleInGroup;
            } else if (numberOfPeopleInGroup <= 12) {
                montBlanc+=numberOfPeopleInGroup;
            } else if (numberOfPeopleInGroup <= 25) {
                kilimanjaro+=numberOfPeopleInGroup;
            } else if (numberOfPeopleInGroup <= 40) {
                kTwo+=numberOfPeopleInGroup;
            } else {
                everest+=numberOfPeopleInGroup;
            }
        }
        System.out.printf("%.2f%%\n", (musala /  totalCountOfPeople) * 100);
        System.out.printf("%.2f%%\n", (montBlanc /  totalCountOfPeople) * 100);
        System.out.printf("%.2f%%\n", (kilimanjaro /  totalCountOfPeople) * 100);
        System.out.printf("%.2f%%\n", (kTwo /  totalCountOfPeople) * 100);
        System.out.printf("%.2f%%\n", (everest /  totalCountOfPeople) * 100);
    }
}
