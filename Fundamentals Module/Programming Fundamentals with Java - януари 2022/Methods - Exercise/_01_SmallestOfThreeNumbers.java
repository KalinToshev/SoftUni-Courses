package bg.softuni.MethodsExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _01_SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        findSmallestOfThreeNumbersWithList(scanner, numbers);
    }

    private static void findSmallestOfThreeNumbersWithList(Scanner scanner, List<Integer> numbers) {
        numbers.add(Integer.parseInt(scanner.nextLine()));
        numbers.add(Integer.parseInt(scanner.nextLine()));
        numbers.add(Integer.parseInt(scanner.nextLine()));
        Collections.sort(numbers);
        System.out.println(numbers.get(0));
    }

}
