import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> persons = new ArrayList<>();

        int personalInformationLines = Integer.parseInt(scanner.nextLine());
        while (personalInformationLines-- > 0) {
            String personalInformation = scanner.nextLine();
            String name = personalInformation.split("\\s+")[0];
            int age = Integer.parseInt(personalInformation.split("\\s+")[1]);
            Person person = new Person(name, age);
            if (age > 30) {
             persons.add(person);
            }
        }
        persons.sort(Comparator.comparing(Person::getName));
        for (Person person : persons) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}
