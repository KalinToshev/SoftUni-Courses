package bg.softuni.ListExercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> integers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> removedElements = new ArrayList<>();

        boolean emptyArr = false;
        while (!emptyArr) {
            //Get index from the console
            int index = Integer.parseInt(scanner.nextLine());

            //If the given index is LESS than 0
            if (index < 0) {
                int lastElement = integers.get(integers.size() - 1);
                int removedElement = integers.get(0);
                removedElements.add(removedElement);
                integers.set(0, lastElement);
                for (int i = 0; i < integers.size(); i++) {
                    if (integers.get(i) <= removedElement) {
                        integers.set(i, integers.get(i) + removedElement);
                    } else if (integers.get(i) > removedElement) {
                        integers.set(i, integers.get(i) - removedElement);
                    }
                }
            }

            //If the given index is GREATER than the last index of the sequence
            if (index >= integers.size()) {
                int firstElement = integers.get(0);
                int removedElement = integers.get(integers.size() - 1);
                removedElements.add(removedElement);
                integers.set(integers.size() - 1, firstElement);
                for (int i = 0; i < integers.size(); i++) {
                    if (integers.get(i) <= removedElement) {
                        integers.set(i, integers.get(i) + removedElement);
                    } else if (integers.get(i) > removedElement) {
                        integers.set(i, integers.get(i) - removedElement);
                    }
                }
            }

            //If given index is in valid range
            if (index >= 0 && index < integers.size()) {
                removedElements.add(integers.get(index));
                int elementValue = integers.get(index);
                integers.remove(index);
                for (int i = 0; i < integers.size(); i++) {
                    if (integers.get(i) <= elementValue) {
                        integers.set(i, integers.get(i) + elementValue);
                    } else if (integers.get(i) > elementValue) {
                        integers.set(i, integers.get(i) - elementValue);
                    }
                }
            }

            //If main list is empty end the while loop
            if (integers.size() == 0) {
                emptyArr = true;
            }
        }

        int sum = 0;
        for (Integer removedElement : removedElements) {
            sum += removedElement;
        }
        System.out.println(sum);
    }
}
