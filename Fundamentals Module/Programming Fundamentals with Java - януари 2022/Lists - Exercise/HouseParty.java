package bg.softuni.ListExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int command = Integer.parseInt(scanner.nextLine());

        List<String> guests = new ArrayList<>();

        for (int i = 0; i < command; i++) {
            String[] tokens = scanner.nextLine().split(" ");

            if (tokens.length == 3) {
                if (guests.contains(tokens[0])) {
                    System.out.println(tokens[0] + " is already in the list!");
                } else {
                    guests.add(tokens[0]);
                }
            } else {
                if (guests.contains(tokens[0])) {
                    guests.remove(tokens[0]);
                } else {
                    System.out.println(tokens[0] + " is not in the list!");
                }
            }
        }

        guests.forEach(v -> System.out.println(v));
    }
}
