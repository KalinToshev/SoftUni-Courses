package InterfacesAndAbstractionLab.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> identifiableList = new ArrayList<>();

        String line;
        while (!"End".equals(line = scanner.nextLine())) {
            String[] tokens = line.split("\\s+");
            if (tokens.length == 3) {
                //citizen
                String name = tokens[0];
                int age = Integer.parseInt(tokens[1]);
                String id = tokens[2];

                Citizen citizen = new Citizen(name, age, id);
                identifiableList.add(citizen);
            } else {
                //robot
                String model = tokens[0];
                String id = tokens[1];

                Robot robot = new Robot(model, id);
                identifiableList.add(robot);
            }
        }

        String theLastDigitsOfFakeIds = scanner.nextLine();

        identifiableList.stream().filter(s -> s.getId().endsWith(theLastDigitsOfFakeIds)).forEach(s -> System.out.println(s.getId()));
    }
}
