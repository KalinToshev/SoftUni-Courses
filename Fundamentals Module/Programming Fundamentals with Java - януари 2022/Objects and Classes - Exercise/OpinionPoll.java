package bg.softuni.ObjectsAndClassesExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class OpinionPoll {
    static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> peoples = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);

            Person person = new Person(name, age);

            peoples.add(person);
        }

        List<Person> peopleWithAgeMoreThan30 = peoples.stream().filter(p -> p.getAge() > 30).collect(Collectors.toList());

        for (Person person : peopleWithAgeMoreThan30) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}
