package InterfacesAndAbstractionExercise.BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthableList = new ArrayList<>();

        String line;
        while (!"End".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("\\s+");
            switch (tokens[0]) {
                case "Citizen":
                    String name = tokens[1];
                    int age = Integer.parseInt(tokens[2]);
                    String id = tokens[3];
                    String birthDay = tokens[4];
                    Citizen citizen = new Citizen(name, age, id, birthDay);
                    birthableList.add(citizen);
                    break;
                case "Pet":
                    name = tokens[1];
                    birthDay = tokens[2];
                    Pet pet = new Pet(name, birthDay);
                    birthableList.add(pet);
                    break;
            }
        }

        String specificYear = scanner.nextLine();

        birthableList.stream()
                .filter(e -> e.getBirthDate().endsWith(specificYear))
                .forEach(birthable -> System.out.println(birthable.getBirthDate()));
    }
}
