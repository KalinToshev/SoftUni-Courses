package JavaAdvancedExam26June2021.OSPlaning01;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //some tasks as integer values
        int[] someTasksAsIntVal = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray(); //stack
        //threads as integer values
        int[] someThreadsAsIntVal = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray(); //queue

        //integer value of a task that you need to kill
        int valueOfTaskToKill = Integer.parseInt(scanner.nextLine());

        Deque<Integer> tasks = new ArrayDeque<>();
        Arrays.stream(someTasksAsIntVal).forEach(tasks::push);
        Deque<Integer> threads = new ArrayDeque<>();
        Arrays.stream(someThreadsAsIntVal).forEach(threads::offer);

        while (true) {
            if(tasks.peek() == valueOfTaskToKill){
                System.out.println("Thread with value " + threads.peek() + " killed task " + valueOfTaskToKill);
                break;
            } else if(threads.peek() >= tasks.peek()) {
                tasks.pop();
                threads.poll();
            } else {
                threads.poll();
            }
        }
        System.out.println(threads.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}
