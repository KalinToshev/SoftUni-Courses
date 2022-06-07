import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> personMap = new HashMap<>();

        String command;
        while (!"End".equals(command = scanner.nextLine())) {
            String[] tokens = command.split("\\s+");

            String name = tokens[0];

            personMap.putIfAbsent(name, new Person(name));

            Person singlePerson = personMap.get(name);
            switch (tokens[1]) {
                case "company":
                    singlePerson.setCompany(new Company(tokens[2], tokens[3], Double.parseDouble(tokens[4])));
                    break;
                case "pokemon":
                    singlePerson.setPokemons(new Pokemon(tokens[2], tokens[3]));
                    break;
                case "parents":
                    singlePerson.setParents(new Parent(tokens[2], tokens[3]));
                    break;
                case "children":
                    singlePerson.setChildrens(new Children(tokens[2], tokens[3]));
                    break;
                case "car":
                    singlePerson.setCar(new Car(tokens[2], tokens[3]));
                    break;
            }
        }
        System.out.println(personMap.get(scanner.nextLine()));
    }
}
