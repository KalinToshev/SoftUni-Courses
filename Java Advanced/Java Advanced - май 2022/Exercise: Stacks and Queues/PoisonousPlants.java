import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> plants = new ArrayDeque<>();
        int n = Integer.parseInt(scanner.nextLine());
        int[] pesticide = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        for (int i = n - 1; i >= 0; i--) {
            plants.offer(pesticide[i]);
        }
        int day =-1;
        boolean haveDead = false;
        do {
            haveDead = false;
            for (int i = plants.size()-1; i > 0; i--) {
                int temp = plants.poll();
                int left = plants.peek();
                if (temp > left) {
                    haveDead = true;
                } else {
                    plants.offer(temp);
                }
            }
            plants.offer(plants.pop());
            day++;
        } while (haveDead);
        System.out.println(day);
    }
}

