package EncapsulationExercise.ShoppingSpree;

import java.util.*;

public class Main {
    static Map<String, Person> personMap = new LinkedHashMap<>();
    static Map<String, Product> productMap = new LinkedHashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        fillPerson(scanner);

        fillProducts(scanner);

        shopping(scanner);

        printPersons();
    }

    private static void printPersons() {
        personMap.values().forEach(System.out::println);
    }

    private static void shopping(Scanner scanner) {
        String command;
        while (!"END".equals(command = scanner.nextLine())) {
            String person = command.split(" ")[0];
            String product = command.split(" ")[1];

            personMap.get(person).buyProduct(productMap.get(product));
        }
    }

    private static void fillProducts(Scanner scanner) {
        String[] productsInputData = scanner.nextLine().split(";");
        for (String singleProduct : productsInputData) {
            String productName = singleProduct.split("=")[0];
            double productCost = Double.parseDouble(singleProduct.split("=")[1]);
            productMap.putIfAbsent(productName, new Product(productName, productCost));
        }
    }

    private static void fillPerson(Scanner scanner) {
        String[] personsInputData = scanner.nextLine().split(";");
        for (String singlePerson : personsInputData) {
            String name = singlePerson.split("=")[0];
            double money = Double.parseDouble(singlePerson.split("=")[1]);
            personMap.putIfAbsent(name, new Person(name, money));
        }
    }
}
