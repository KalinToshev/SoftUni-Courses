package Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        String fullName = input[0] + " " + input[1];
        String address = input[2];

        Tuple<String, String> tuple1 = new Tuple<String, String>(fullName, address);
        System.out.println(tuple1);

        input = scanner.nextLine().split(" ");

        String name= input[0];
        int litersOfBeer = Integer.parseInt(input[1]);

        Tuple<String, Integer> tuple2 = new Tuple<>(name, litersOfBeer);
        System.out.println(tuple2);

        input = scanner.nextLine().split(" ");

        int num1 = Integer.parseInt(input[0]);
        double num2 = Double.parseDouble(input[1]);

        Tuple<Integer, Double> tuple3 = new Tuple<>(num1, num2);
        System.out.println(tuple3);

    }
}
