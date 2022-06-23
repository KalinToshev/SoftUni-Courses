package JavaAdvancedRetakeExam16December2020.Cooking01;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> cookedFood = new TreeMap<>();
        cookedFood.put("Bread", 0);
        cookedFood.put("Cake", 0);
        cookedFood.put("Pastry", 0);
        cookedFood.put("Fruit Pie", 0);

        Deque<Integer> liquids = new ArrayDeque<>(); //queue
        Deque<Integer> ingredients = new ArrayDeque<>(); //stack

        //fill
        String[] firstInput = scanner.nextLine().split("\\s+");
        String[] secondInput = scanner.nextLine().split("\\s+");
        Arrays.stream(firstInput).mapToInt(Integer::parseInt).forEach(liquids::offer);
        Arrays.stream(secondInput).mapToInt(Integer::parseInt).forEach(ingredients::push);

        while (!(liquids.isEmpty() || ingredients.isEmpty())) {
            int firstLiquid = liquids.poll();
            int lastIngredient = ingredients.pop();
            int sum = firstLiquid + lastIngredient;
            switch (sum) {
                case 25:
                        cookedFood.put("Bread", cookedFood.get("Bread") + 1);
                    break;
                case 50:
                        cookedFood.put("Cake", cookedFood.get("Cake") + 1);
                    break;
                case 75:
                        cookedFood.put("Pastry", cookedFood.get("Pastry") + 1);
                    break;
                case 100:
                        cookedFood.put("Fruit Pie", cookedFood.get("Fruit Pie") + 1);
                    break;
                default:
                    lastIngredient += 3;
                    ingredients.push(lastIngredient);
                    break;
            }
        }

        int cookedFoods = 0;
        for (Map.Entry<String, Integer> entry : cookedFood.entrySet()) {
            if (entry.getValue() > 0) {
                cookedFoods++;
            }
        }
        if (cookedFoods == 4) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        } else {
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.isEmpty()) {
            System.out.println("Liquids left: none");
        } else {
            String liquidsLeft = liquids.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.print("Liquids left: " + liquidsLeft + System.lineSeparator());
        }

        if (ingredients.isEmpty()) {
            System.out.println("Ingredients left: none");
        } else {
            String ingredientsLeft = ingredients.stream().map(String::valueOf).collect(Collectors.joining(", "));
            System.out.print("Ingredients left: " + ingredientsLeft + System.lineSeparator());
        }

        for (Map.Entry<String, Integer> entry : cookedFood.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
