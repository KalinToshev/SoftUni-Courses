package EncapsulationLab.ValidationData;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        while (numberOfPeople-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");

            Person personToAdd = new Person(input[0], input[1], Integer.parseInt(input[2]), Double.parseDouble(input[3]));
            people.add(personToAdd);
        }

        double bonus = Double.parseDouble(scanner.nextLine());

        people.forEach(person -> {
            person.increaseSalary(bonus);
            System.out.println(person);
        });
    }
}
