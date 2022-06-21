package JavaAdvancedRetakeExam18August2021.PastryShop01;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> cookedFood = new LinkedHashMap<>();
        cookedFood.put("Biscuit", 0);
        cookedFood.put("Cake", 0);
        cookedFood.put("Pie", 0);
        cookedFood.put("Pastry", 0);

        int[] liquidsIntegers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray(); //to queue
        int[] ingredientsIntegers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray(); //to stack

        Deque<Integer> liquids = new ArrayDeque<>();
        Arrays.stream(liquidsIntegers).forEach(liquids::offer);
        Deque<Integer> ingredients = new ArrayDeque<>();
        Arrays.stream(ingredientsIntegers).forEach(ingredients::push);

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            int firstLiquid = liquids.poll();
            int lastIngredient = ingredients.pop();

            int sum = firstLiquid + lastIngredient;
            switch (sum) {
                case 25:
                    int cooked = cookedFood.get("Biscuit") + 1;
                    cookedFood.put("Biscuit", cooked);
                    break;
                case 50:
                    cooked = cookedFood.get("Cake") + 1;
                    cookedFood.put("Cake", cooked);
                    break;
                case 75:
                    cooked = cookedFood.get("Pastry") + 1;
                    cookedFood.put("Pastry", cooked);
                    break;
                case 100:
                    cooked = cookedFood.get("Pie") + 1;
                    cookedFood.put("Pie", cooked);
                    break;
                default:
                    lastIngredient += 3;
                    ingredients.push(lastIngredient);
                    break;
            }
        }

        checkCooked(cookedFood);
        remainingLiquids(liquids);
        remainingIngredients(ingredients);
        cookedFood(cookedFood);
    }

    private static void cookedFood(Map<String, Integer> cookedFood) {
        cookedFood.entrySet()
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    private static void remainingIngredients(Deque<Integer> ingredients) {
        String remainingIngredients = ingredients.isEmpty() ? "none" : ingredients.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Ingredients left: " + remainingIngredients);
    }

    private static void remainingLiquids(Deque<Integer> liquids) {
        String remainingLiquids = liquids.isEmpty() ? "none" : liquids.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println("Liquids left: " + remainingLiquids);
    }

    private static void checkCooked(Map<String, Integer> cookedFood) {
        boolean allCooked = false;
        int cookedFoods = 0;
        for (Map.Entry<String, Integer> entry : cookedFood.entrySet()) {
            if (entry.getValue() > 0) {
                cookedFoods++;
            }
        }
        if (cookedFoods == 4) {
            allCooked = true;
        }
        if (allCooked) {
            System.out.println("Great! You succeeded in cooking all the food!");
        } else {
            System.out.println("What a pity! You didn't have enough materials to cook everything.");
        }
    }
}
