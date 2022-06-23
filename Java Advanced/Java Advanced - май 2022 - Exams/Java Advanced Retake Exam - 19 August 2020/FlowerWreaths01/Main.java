package JavaAdvancedRetakeExam19August2020.FlowerWreaths01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deque<Integer> lilies = new ArrayDeque<>(); //stack
        Deque<Integer>  roses = new ArrayDeque<>(); //queue

        int[] rosesIntegers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int[] liliesIntegers = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();

        Arrays.stream(rosesIntegers).forEach(roses::offer);
        Arrays.stream(liliesIntegers).forEach(lilies::push);

        int wreaths = 0;
        int storeFlower = 0;
        while (!(roses.isEmpty() || lilies.isEmpty())) {
            int lastLilies = lilies.pop();
            int firstRoses = roses.poll();

            while (true){
                if (lastLilies + firstRoses < 15) {
                    storeFlower += lastLilies + firstRoses;
                    break;
                } else if (lastLilies + firstRoses == 15) {
                    wreaths++;
                    break;
                } else {
                    lastLilies -= 2;
                }
            }
        }
        wreaths += storeFlower / 15;
        if (wreaths >= 5) {
            System.out.println("You made it, you are going to the competition with " + wreaths + " wreaths!");
        } else {
            System.out.println("You didn't make it, you need " + (5-wreaths) + " wreaths more!");
        }
    }
}
