package bg.softuni.ListExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> handOne = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> handTwo = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        //TODO: Compare the cards from the first deck to the cards from the second deck.
        while (handOne.size() > 0 && handTwo.size() > 0) {
            if (handOne.get(0).equals(handTwo.get(0))) {
                handOne.remove(0);
                handTwo.remove(0);
            } else if (handOne.get(0) > handTwo.get(0)) {
                handOne.add(handOne.get(0));
                handOne.add(handTwo.get(0));
                handTwo.remove(0);
                handOne.remove(0);
            } else if (handOne.get(0) < handTwo.get(0)) {
                handTwo.add(handTwo.get(0));
                handTwo.add(handOne.get(0));
                handTwo.remove(0);
                handOne.remove(0);
            }
        }
        int sum = 0;
        if (handOne.size() > 0) {
            for (Integer num : handOne) {
                sum += num;
            }
            System.out.println("First player wins! Sum: " + sum);
        } else {
            for (Integer num : handTwo) {
                sum += num;
            }
            System.out.println("Second player wins! Sum: " + sum);
        }

    }
}
