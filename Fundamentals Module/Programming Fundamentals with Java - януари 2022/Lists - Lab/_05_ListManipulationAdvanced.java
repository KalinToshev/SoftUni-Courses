package bg.softuni.ListsLab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05_ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers =
                Arrays.stream(scanner.nextLine().split(" "))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());

        while (true) {
            String line = scanner.nextLine();
            if (line.equals("end")) {
                break;
            }

            String[] tokens = line.split(" ");
            switch (tokens[0]) {
                case "Contains":
                    int number = Integer.parseInt(tokens[1]);
                    boolean contains = false;
                    for (int i = 0; i < numbers.size(); i++) {
                        if (numbers.get(i) == number) {
                            contains = true;
                        }
                    }
                    if (contains) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    switch (tokens[1]) {
                        case "even":
                            List<Integer> evenNumbers = new ArrayList<>();
                            for (Integer value : numbers) {
                                if (value % 2 == 0) {
                                    evenNumbers.add(value);
                                }
                            }
                            for (Integer evenNumber : evenNumbers) {
                                System.out.print(evenNumber + " ");
                            }
                            System.out.println();
                            break;
                        case "odd":
                            List<Integer> oddNumbers = new ArrayList<>();
                            for (Integer integer : numbers) {
                                if (integer % 2 == 1) {
                                    oddNumbers.add(integer);
                                }
                            }
                            for (Integer oddNumber : oddNumbers) {
                                System.out.print(oddNumber + " ");
                            }
                            System.out.println();
                            break;
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (Integer integer : numbers) {
                        sum += integer;
                    }
                    System.out.println(sum);
                    break;
                case "Filter":
                    String condition = tokens[1];
                    int anotherNumber = Integer.parseInt(tokens[2]);

                    if (condition.equals("<")) {
                        List<Integer> smallerCondition = new ArrayList<>();
                        for (Integer value : numbers) {
                            if (value < anotherNumber) {
                                smallerCondition.add(value);
                            }
                        }
                        for (Integer integer : smallerCondition) {
                            System.out.print(integer + " ");
                        }
                        System.out.println();
                    }

                    if (condition.equals(">")) {
                        List<Integer> biggerCondition = new ArrayList<>();
                        for (Integer value : numbers) {
                            if (value > anotherNumber) {
                                biggerCondition.add(value);
                            }
                        }
                        for (Integer integer : biggerCondition) {
                            System.out.println(integer + " ");
                        }
                        System.out.println();
                    }

                    if (condition.equals(">=")) {
                        List<Integer> biggerOrEqualCondition = new ArrayList<>();
                        for (Integer value : numbers) {
                            if (value >= anotherNumber) {
                                biggerOrEqualCondition.add(value);
                            }
                        }
                        for (Integer integer : biggerOrEqualCondition) {
                            System.out.print(integer + " ");
                        }
                        System.out.println();
                    }

                    if (condition.equals("<=")) {
                        List<Integer> smallerOrEqualCondition = new ArrayList<>();
                        for (Integer value : numbers) {
                            if (value <= anotherNumber) {
                                smallerOrEqualCondition.add(value);
                            }
                        }
                        for (Integer integer : smallerOrEqualCondition) {
                            System.out.print(integer + " ");
                        }
                        System.out.println();
                    }
                    break;
            }
        }
    }
}
