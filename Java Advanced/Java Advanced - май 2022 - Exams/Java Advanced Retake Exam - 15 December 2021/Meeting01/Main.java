package JavaAdvancedRetakeExam15December2021.Meeting01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String malesLine = scanner.nextLine();
        String femalesLine = scanner.nextLine();

        //first female -> queue FIFO
        Deque<Integer> females = new ArrayDeque<>();
        Arrays.stream(femalesLine.split(" ")).mapToInt(Integer::parseInt).forEach(females::offer);
        //last male -> stack LIFO
        Deque<Integer> males = new ArrayDeque<>();
        Arrays.stream(malesLine.split(" ")).mapToInt(Integer::parseInt).forEach(males::push);

        int matches = 0;

        while (!(males.isEmpty() || females.isEmpty())) {

            if(males.peek()<=0){
                males.pop();
                continue;
            }
            if(females.peek()<=0){
                females.poll();
                continue;
            }
            if(males.peek()%25==0){
                males.pop();
                males.pop();
                continue;
            }
            if(females.peek()%25==0){
                females.poll();
                females.poll();
                continue;
            }
            int singleMale = males.pop();
            int singleWoman = females.poll();
            if(singleMale==singleWoman) {
                matches++;
            } else {
                males.push(singleMale-2);
            }
        }

        matchesOutput(matches);
        malesOutput(males);
        femalesOutput(females);
    }

    private static void matchesOutput(int matches) {
        System.out.println("Matches: " + matches);
    }

    private static void malesOutput(Deque<Integer> males) {
        String result;
        if(males.isEmpty()) {
            result = "Males left: none";
        } else {
            result = String.format("Males left: %s", males.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.println(result);
    }

    private static void femalesOutput(Deque<Integer> females) {
        String result;
        if(females.isEmpty()) {
            result = "Females left: none";
        } else {
            result = String.format("Females left: %s", females.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }
        System.out.println(result);
    }
}
