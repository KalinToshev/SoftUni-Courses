package JavaAdvancedRetakeExam14April2021.Bouquets01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //one bouquet needs 15 flowers
        //goal is to make at least 5 bouquets

        Deque<Integer> tulips = new ArrayDeque<>(); //stack
        Deque<Integer> daffodils = new ArrayDeque<>(); //queue

        String tulipsInput = scanner.nextLine();
        Arrays.stream(tulipsInput.split(", ")).mapToInt(Integer::parseInt).forEach(tulips::push);
        String daffodilsInput = scanner.nextLine();
        Arrays.stream(daffodilsInput.split(", ")).mapToInt(Integer::parseInt).forEach(daffodils::offer);

        int bouquets = 5;
        int storeFlower = 0;
        while (!(daffodils.isEmpty() || tulips.isEmpty()) || bouquets > 5) {
            int singleTulips = tulips.pop();
            int singleDaffodils = daffodils.poll();
            while (true){
                if (singleDaffodils + singleTulips < 15) {
                    storeFlower += singleDaffodils + singleTulips;
                    break;
                } else if (singleDaffodils + singleTulips == 15) {
                    bouquets--;
                    break;
                } else {
                    singleTulips -= 2;
                }
            }
        }
        bouquets -= storeFlower / 15;
        if (bouquets <= 0) {
            System.out.println("You made it! You go to the competition with 5 bouquets!");
        } else {
            System.out.println("You failed... You need more " + bouquets + " bouquets.");
        }
    }
}
