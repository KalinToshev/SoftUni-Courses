package JavaAdvancedExam23October2021.AutumnCocktails01;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, String> needResourcesForCocktail = new HashMap<>();
        needResourcesForCocktail.put(150, "Pear Sour");
        needResourcesForCocktail.put(250, "The Harvest");
        needResourcesForCocktail.put(300, "Apple Hinny");
        needResourcesForCocktail.put(400, "High Fashion");

        Map<String, Integer> makeCocktails = new TreeMap<>();

        Deque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(ingredients::offer); //queue
        Deque<Integer> freshness =  new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).forEach(freshness::push); //stack

        while (!(ingredients.isEmpty() || freshness.isEmpty())) {
            int singleIngredients = ingredients.poll();
            if(singleIngredients==0){
                continue;
            }
            int singleFreshness = freshness.pop();

            int totalFreshnessLevel  = singleIngredients * singleFreshness;

            if (needResourcesForCocktail.containsKey(totalFreshnessLevel)) {
                String makeCocktail = needResourcesForCocktail.get(totalFreshnessLevel);
                makeCocktails.putIfAbsent(makeCocktail, 0);
                makeCocktails.put(makeCocktail, makeCocktails.get(makeCocktail) + 1);
            } else {
                ingredients.offer(singleIngredients + 5);
            }
        }

        if(makeCocktails.size()==4) {
            System.out.println("It's party time! The cocktails are ready!");
        } else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }

        if (!ingredients.isEmpty()) {
            int sum = 0;
            while (!ingredients.isEmpty()) {
                sum += ingredients.poll();
            }
            System.out.println("Ingredients left: " + sum);
        }

        makeCocktails.forEach((key, value) -> System.out.printf(" # %s --> %d%n", key, value));
    }
}
