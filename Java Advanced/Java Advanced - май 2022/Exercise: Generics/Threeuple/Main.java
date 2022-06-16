package Threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        String fullName = input[0] + " " + input[1];
        String address = input[2];
        String town = input[3];

        Threeuple<String, String, String> threeuple1 = new Threeuple<>(fullName, address, town);
        System.out.println(threeuple1);

        input = scanner.nextLine().split(" ");
        String name = input[0];
        int litersOfBeer = Integer.parseInt(input[1]);
        boolean drunkOrNot = input[2].equals("drunk");

        Threeuple<String, Integer, Boolean> threeuple2 = new Threeuple<>(name, litersOfBeer, drunkOrNot);
        System.out.println(threeuple2);

        input = scanner.nextLine().split(" ");
        name = input[0];
        double accountBalance = Double.parseDouble(input[1]);
        String bankName = input[2];

        Threeuple<String, Double, String> threeuple3 = new Threeuple<>(name, accountBalance, bankName);
        System.out.println(threeuple3);
    }
}
